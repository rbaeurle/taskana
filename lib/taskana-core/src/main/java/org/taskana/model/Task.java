package org.taskana.model;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Map;

/**
 * Task entity.
 */
public class Task {

    private String id;
    private String tenantId;
    private Timestamp created;
    private Timestamp claimed;
    private Timestamp completed;
    private Timestamp modified;
    private Timestamp planned;
    private Timestamp due;
    private String name;
    private String description;
    private int priority;
    private TaskState state;
    private Classification classification;
    private String workbasketId;
    private String owner;
    private ObjectReference primaryObjRef;
    private boolean isRead;
    private boolean isTransferred;
    // All objects have to be serializable
    private Map<String, Object> customAttributes = Collections.emptyMap();
    private String custom1;
    private String custom2;
    private String custom3;
    private String custom4;
    private String custom5;
    private String custom6;
    private String custom7;
    private String custom8;
    private String custom9;
    private String custom10;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getClaimed() {
        return claimed;
    }

    public void setClaimed(Timestamp claimed) {
        this.claimed = claimed;
    }

    public Timestamp getCompleted() {
        return completed;
    }

    public void setCompleted(Timestamp completed) {
        this.completed = completed;
    }

    public Timestamp getModified() {
        return modified;
    }

    public void setModified(Timestamp modified) {
        this.modified = modified;
    }

    public Timestamp getPlanned() {
        return planned;
    }

    public void setPlanned(Timestamp planned) {
        this.planned = planned;
    }

    public Timestamp getDue() {
        return due;
    }

    public void setDue(Timestamp due) {
        this.due = due;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public String getWorkbasketId() {
        return workbasketId;
    }

    public void setWorkbasketId(String workbasketId) {
        this.workbasketId = workbasketId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public ObjectReference getPrimaryObjRef() {
        return primaryObjRef;
    }

    public void setPrimaryObjRef(ObjectReference primaryObjRef) {
        this.primaryObjRef = primaryObjRef;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    public boolean isTransferred() {
        return isTransferred;
    }

    public void setTransferred(boolean isTransferred) {
        this.isTransferred = isTransferred;
    }

    public Map<String, Object> getCustomAttributes() {
        return customAttributes;
    }

    public void setCustomAttributes(Map<String, Object> customAttributes) {
        this.customAttributes = customAttributes;
    }

    public String getCustom1() {
        return custom1;
    }

    public void setCustom1(String custom1) {
        this.custom1 = custom1;
    }

    public String getCustom2() {
        return custom2;
    }

    public void setCustom2(String custom2) {
        this.custom2 = custom2;
    }

    public String getCustom3() {
        return custom3;
    }

    public void setCustom3(String custom3) {
        this.custom3 = custom3;
    }

    public String getCustom4() {
        return custom4;
    }

    public void setCustom4(String custom4) {
        this.custom4 = custom4;
    }

    public String getCustom5() {
        return custom5;
    }

    public void setCustom5(String custom5) {
        this.custom5 = custom5;
    }

    public String getCustom6() {
        return custom6;
    }

    public void setCustom6(String custom6) {
        this.custom6 = custom6;
    }

    public String getCustom7() {
        return custom7;
    }

    public void setCustom7(String custom7) {
        this.custom7 = custom7;
    }

    public String getCustom8() {
        return custom8;
    }

    public void setCustom8(String custom8) {
        this.custom8 = custom8;
    }

    public String getCustom9() {
        return custom9;
    }

    public void setCustom9(String custom9) {
        this.custom9 = custom9;
    }

    public String getCustom10() {
        return custom10;
    }

    public void setCustom10(String custom10) {
        this.custom10 = custom10;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("TASK(");
        sb.append("id=" + id);
        sb.append(", tenantId=" + tenantId);
        sb.append(", created=" + created);
        sb.append(", claimed=" + claimed);
        sb.append(", completed=" + completed);
        sb.append(", modified=" + modified);
        sb.append(", planned=" + planned);
        sb.append(", due=" + due);
        sb.append(", name=" + name);
        sb.append(", description=" + description);
        sb.append(", priority=" + priority);
        sb.append(", state=" + state);
        sb.append(", classification=" + classification);
        sb.append(", workbasketId=" + workbasketId);
        sb.append(", owner=" + owner);
        sb.append(", primaryObjRef=" + primaryObjRef);
        sb.append(", isRead=" + isRead);
        sb.append(", isTransferred=" + isTransferred);
        sb.append(", custom1=" + custom1);
        sb.append(", custom2=" + custom2);
        sb.append(", custom3=" + custom3);
        sb.append(", custom4=" + custom4);
        sb.append(", custom5=" + custom5);
        sb.append(", custom6=" + custom6);
        sb.append(", custom7=" + custom7);
        sb.append(", custom8=" + custom8);
        sb.append(", custom9=" + custom9);
        sb.append(", custom10=" + custom10);
        sb.append(")");
        return sb.toString();
    }
}
