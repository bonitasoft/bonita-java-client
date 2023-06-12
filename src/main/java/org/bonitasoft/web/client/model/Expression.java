/** 
 * Copyright (C) 2022 BonitaSoft S.A.
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Expression
 */
@JsonPropertyOrder({
        Expression.JSON_PROPERTY_ID,
        Expression.JSON_PROPERTY_NAME,
        Expression.JSON_PROPERTY_CONTENT,
        Expression.JSON_PROPERTY_EXPRESSION_TYPE,
        Expression.JSON_PROPERTY_RETURN_TYPE,
        Expression.JSON_PROPERTY_INTERPRETER,
        Expression.JSON_PROPERTY_DEPENDENCIES
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class Expression implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String JSON_PROPERTY_ID = "id";
    private String id;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    public static final String JSON_PROPERTY_CONTENT = "content";
    private String content;

    public static final String JSON_PROPERTY_EXPRESSION_TYPE = "expressionType";
    private String expressionType;

    public static final String JSON_PROPERTY_RETURN_TYPE = "returnType";
    private String returnType;

    public static final String JSON_PROPERTY_INTERPRETER = "interpreter";
    private String interpreter;

    public static final String JSON_PROPERTY_DEPENDENCIES = "dependencies";
    private List<Expression> dependencies;

    public Expression() {
    }

    public Expression id(String id) {

        this.id = id;
        return this;
    }

    /**
     * the expression id
     * 
     * @return id
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getId() {
        return id;
    }

    @JsonProperty(JSON_PROPERTY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setId(String id) {
        this.id = id;
    }

    public Expression name(String name) {

        this.name = name;
        return this;
    }

    /**
     * the expression name
     * 
     * @return name
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getName() {
        return name;
    }

    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setName(String name) {
        this.name = name;
    }

    public Expression content(String content) {

        this.content = content;
        return this;
    }

    /**
     * the expression content
     * 
     * @return content
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_CONTENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getContent() {
        return content;
    }

    @JsonProperty(JSON_PROPERTY_CONTENT)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setContent(String content) {
        this.content = content;
    }

    public Expression expressionType(String expressionType) {

        this.expressionType = expressionType;
        return this;
    }

    /**
     * the expression type
     * 
     * @return expressionType
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_EXPRESSION_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getExpressionType() {
        return expressionType;
    }

    @JsonProperty(JSON_PROPERTY_EXPRESSION_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setExpressionType(String expressionType) {
        this.expressionType = expressionType;
    }

    public Expression returnType(String returnType) {

        this.returnType = returnType;
        return this;
    }

    /**
     * the expression return type
     * 
     * @return returnType
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_RETURN_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getReturnType() {
        return returnType;
    }

    @JsonProperty(JSON_PROPERTY_RETURN_TYPE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public Expression interpreter(String interpreter) {

        this.interpreter = interpreter;
        return this;
    }

    /**
     * the expression interpreter
     * 
     * @return interpreter
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_INTERPRETER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getInterpreter() {
        return interpreter;
    }

    @JsonProperty(JSON_PROPERTY_INTERPRETER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setInterpreter(String interpreter) {
        this.interpreter = interpreter;
    }

    public Expression dependencies(List<Expression> dependencies) {

        this.dependencies = dependencies;
        return this;
    }

    public Expression addDependenciesItem(Expression dependenciesItem) {
        if (this.dependencies == null) {
            this.dependencies = new ArrayList<>();
        }
        this.dependencies.add(dependenciesItem);
        return this;
    }

    /**
     * the expression dependencies
     * 
     * @return dependencies
     **/
    @jakarta.annotation.Nullable
    @JsonProperty(JSON_PROPERTY_DEPENDENCIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<Expression> getDependencies() {
        return dependencies;
    }

    @JsonProperty(JSON_PROPERTY_DEPENDENCIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
    public void setDependencies(List<Expression> dependencies) {
        this.dependencies = dependencies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Expression expression = (Expression) o;
        return Objects.equals(this.id, expression.id) &&
                Objects.equals(this.name, expression.name) &&
                Objects.equals(this.content, expression.content) &&
                Objects.equals(this.expressionType, expression.expressionType) &&
                Objects.equals(this.returnType, expression.returnType) &&
                Objects.equals(this.interpreter, expression.interpreter) &&
                Objects.equals(this.dependencies, expression.dependencies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, content, expressionType, returnType, interpreter, dependencies);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Expression {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
        sb.append("    expressionType: ").append(toIndentedString(expressionType)).append("\n");
        sb.append("    returnType: ").append(toIndentedString(returnType)).append("\n");
        sb.append("    interpreter: ").append(toIndentedString(interpreter)).append("\n");
        sb.append("    dependencies: ").append(toIndentedString(dependencies)).append("\n");
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
