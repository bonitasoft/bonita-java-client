/** 
 * Copyright (C) 2024-2023 BonitaSoft S.A.
 * BonitaSoft, 32 rue Gustave Eiffel - 38000 Grenoble
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.bonitasoft.web.client.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Use this resource to send BPM message events. Message events are caught by processes using &#x60;catch message event&#x60; flow nodes (Start, intermediate,
 * boundary or receive tasks).
 */
@JsonPropertyOrder({
        Message.JSON_PROPERTY_MESSAGE_NAME,
        Message.JSON_PROPERTY_TARGET_PROCESS,
        Message.JSON_PROPERTY_TARGET_FLOW_NODE,
        Message.JSON_PROPERTY_MESSAGE_CONTENT,
        Message.JSON_PROPERTY_CORRELATIONS
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.11.0")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_MESSAGE_NAME = "messageName";
    @jakarta.annotation.Nullable
    private String messageName;

    public static final String JSON_PROPERTY_TARGET_PROCESS = "targetProcess";
    @jakarta.annotation.Nullable
    private String targetProcess;

    public static final String JSON_PROPERTY_TARGET_FLOW_NODE = "targetFlowNode";
    @jakarta.annotation.Nullable
    private String targetFlowNode;

    public static final String JSON_PROPERTY_MESSAGE_CONTENT = "messageContent";
    @jakarta.annotation.Nullable
    private Map<String, MessageMessageContentValue> messageContent = new HashMap<>();

    public static final String JSON_PROPERTY_CORRELATIONS = "correlations";
    @jakarta.annotation.Nullable
    private Map<String, MessageMessageContentValue> correlations = new HashMap<>();

    public Message() {
    }

    public Message messageName(@jakarta.annotation.Nullable String messageName) {

        this.messageName = messageName;
        return this;
    }

    /**
     * the message name
     * 
     * @return messageName
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MESSAGE_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getMessageName() {
        return messageName;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMessageName(@jakarta.annotation.Nullable String messageName) {
        this.messageName = messageName;
    }

    public Message targetProcess(@jakarta.annotation.Nullable String targetProcess) {

        this.targetProcess = targetProcess;
        return this;
    }

    /**
     * the target process name
     * 
     * @return targetProcess
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TARGET_PROCESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTargetProcess() {
        return targetProcess;
    }

    @JsonProperty(JSON_PROPERTY_TARGET_PROCESS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTargetProcess(@jakarta.annotation.Nullable String targetProcess) {
        this.targetProcess = targetProcess;
    }

    public Message targetFlowNode(@jakarta.annotation.Nullable String targetFlowNode) {

        this.targetFlowNode = targetFlowNode;
        return this;
    }

    /**
     * the target FlowNode name
     * 
     * @return targetFlowNode
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_TARGET_FLOW_NODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getTargetFlowNode() {
        return targetFlowNode;
    }

    @JsonProperty(JSON_PROPERTY_TARGET_FLOW_NODE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setTargetFlowNode(@jakarta.annotation.Nullable String targetFlowNode) {
        this.targetFlowNode = targetFlowNode;
    }

    public Message messageContent(@jakarta.annotation.Nullable Map<String, MessageMessageContentValue> messageContent) {

        this.messageContent = messageContent;
        return this;
    }

    public Message putMessageContentItem(String key, MessageMessageContentValue messageContentItem) {
        if (this.messageContent == null) {
            this.messageContent = new HashMap<>();
        }
        this.messageContent.put(key, messageContentItem);
        return this;
    }

    /**
     * the message content
     * 
     * @return messageContent
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_MESSAGE_CONTENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Map<String, MessageMessageContentValue> getMessageContent() {
        return messageContent;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE_CONTENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setMessageContent(@jakarta.annotation.Nullable Map<String, MessageMessageContentValue> messageContent) {
        this.messageContent = messageContent;
    }

    public Message correlations(@jakarta.annotation.Nullable Map<String, MessageMessageContentValue> correlations) {

        this.correlations = correlations;
        return this;
    }

    public Message putCorrelationsItem(String key, MessageMessageContentValue correlationsItem) {
        if (this.correlations == null) {
            this.correlations = new HashMap<>();
        }
        this.correlations.put(key, correlationsItem);
        return this;
    }

    /**
     * the message correlations
     * 
     * @return correlations
     */
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CORRELATIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Map<String, MessageMessageContentValue> getCorrelations() {
        return correlations;
    }

    @JsonProperty(JSON_PROPERTY_CORRELATIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setCorrelations(@jakarta.annotation.Nullable Map<String, MessageMessageContentValue> correlations) {
        this.correlations = correlations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;
        return Objects.equals(this.messageName, message.messageName) &&
                Objects.equals(this.targetProcess, message.targetProcess) &&
                Objects.equals(this.targetFlowNode, message.targetFlowNode) &&
                Objects.equals(this.messageContent, message.messageContent) &&
                Objects.equals(this.correlations, message.correlations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageName, targetProcess, targetFlowNode, messageContent, correlations);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Message {\n");
        sb.append("    messageName: ").append(toIndentedString(messageName)).append("\n");
        sb.append("    targetProcess: ").append(toIndentedString(targetProcess)).append("\n");
        sb.append("    targetFlowNode: ").append(toIndentedString(targetFlowNode)).append("\n");
        sb.append("    messageContent: ").append(toIndentedString(messageContent)).append("\n");
        sb.append("    correlations: ").append(toIndentedString(correlations)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
