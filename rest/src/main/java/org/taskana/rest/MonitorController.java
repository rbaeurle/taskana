package org.taskana.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.taskana.TaskService;
import org.taskana.WorkbasketService;
import org.taskana.model.DueWorkbasketCounter;
import org.taskana.model.TaskState;
import org.taskana.model.TaskStateCounter;
import org.taskana.model.Workbasket;
import org.taskana.rest.model.WorkbasketCounterDataDto;
import org.taskana.rest.model.WorkbasketCounterDto;

@RestController
@RequestMapping(path = "/v1/monitor", produces = { MediaType.APPLICATION_JSON_VALUE })
public class MonitorController {

	@Autowired
	private TaskService taskService;

	@Autowired
	private WorkbasketService workbasketService;

	@RequestMapping(value = "/countByState")
	public ResponseEntity<List<TaskStateCounter>> getTaskcountForState(
			@RequestParam(value = "states") List<TaskState> taskStates) {
		try {
			List<TaskStateCounter> taskCount = taskService.getTaskCountForState(taskStates);
			return ResponseEntity.status(HttpStatus.OK).body(taskCount);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@RequestMapping(value = "/taskcountByWorkbasketDaysAndState")
	public ResponseEntity<?> getTaskCountByWorkbasketAndDaysInPastAndState(
			@RequestParam(value = "daysInPast") Long daysInPast,
			@RequestParam(value = "states") List<TaskState> states) {
		try {
			WorkbasketCounterDto WorkbasketCounterDto = new WorkbasketCounterDto();

			LocalDate date = LocalDate.now();
			date = date.minusDays(daysInPast);
			List<String> dates = new ArrayList<>();

			for (int i = 0; i < (daysInPast * 2 + 1); i++) {
				dates.add(date.format(new DateTimeFormatterBuilder().appendPattern("dd.MM.yyyy").toFormatter()));
				date = date.plusDays(1);
			}
			WorkbasketCounterDto.setDates(dates);

			List<WorkbasketCounterDataDto> data = new ArrayList<>();

			for (Workbasket workbasket : workbasketService.getWorkbaskets()) {
				WorkbasketCounterDataDto counterDto = new WorkbasketCounterDataDto();
				counterDto.setLabel(workbasket.getName());
				List<Integer> zeroData = new ArrayList<>();
				for (int i = 0; i < dates.size(); i++) {
					zeroData.add(0);
				}
				counterDto.setData(zeroData);
				data.add(counterDto);
			}

			List<DueWorkbasketCounter> dwcList = taskService.getTaskCountByWorkbasketAndDaysInPastAndState(daysInPast,
					states);

			for (DueWorkbasketCounter item : dwcList) {
				String formattedDate = item.getDue().toLocalDate()
						.format(new DateTimeFormatterBuilder().appendPattern("dd.MM.yyyy").toFormatter());
				for (int i = 0; i < dates.size(); i++) {
					if (formattedDate.equalsIgnoreCase(dates.get(i))) {
						for (int j = 0; j < data.size(); j++) {
							if (data.get(j).getLabel().equalsIgnoreCase(
									workbasketService.getWorkbasket(item.getWorkbasketId()).getName())) {
								data.get(j).getData().set(i, (int) item.getTaskCounter());
							}
						}
					}
				}
			}

			WorkbasketCounterDto.setData(data);

			return ResponseEntity.status(HttpStatus.OK).body(WorkbasketCounterDto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
