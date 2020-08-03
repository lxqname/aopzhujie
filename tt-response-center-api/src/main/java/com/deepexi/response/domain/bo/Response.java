package com.deepexi.response.domain.bo;





import java.io.Serializable;
import java.util.Date;


/**
 * @description:
 * @program:
 * @author: LiuXinQuan
 * @mail: liuxinquan@deepexi.com
 * @date: 2019/10/12 12:58
 */
public class Response  implements Serializable {

    /**
     * 主键Id
     */
    private String id;

    /**
     * 注册在响应服务中心的其他服务名
     */
    private String registerCenterName;

    /**
     * 响应节点名称
     */
    private String name;

    /**
     * 元数据
     */
    private String metaData;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 请求地址
     */
    private String url;

    /**
     * 请求参数
     */
    private String parameters;

    /**
     * 租户
     */
    private String tenantCode;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 版本记录
     */
    private Integer  version;

    /**
     * 删除标志
     */
    private Integer dr;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegisterCenterName() {
        return registerCenterName;
    }

    public void setRegisterCenterName(String registerCenterName) {
        this.registerCenterName = registerCenterName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }
}
