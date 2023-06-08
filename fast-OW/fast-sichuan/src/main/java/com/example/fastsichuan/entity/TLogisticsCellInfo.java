package com.example.fastsichuan.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 物流单元信息(TLogisticsCellInfo)实体类
 *
 * @author makejava
 * @since 2023-06-04 17:10:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@TableName("t_logistics_cell_info")
public class TLogisticsCellInfo implements Serializable {
    private static final long serialVersionUID = -87668232865232268L;
    /**
     * 主键
     */
    private String id;
    /**
     * 物流单元编码
     */
    private String epc;
    /**
     * 标准箱数
     */
    private String amount;
    /**
     * 箱编码数量
     */
    private String codeAmount;
    /**
     * 实物箱数：1、标准箱数>=箱编码数量，则为箱编码数量；
            2、标准箱数<箱编码数量，则为标准箱数；
     */
    private String realAmount;
    /**
     * 剩余数量，待出库数量
     */
    private String surplusAmount;
    /**
     * 客户端采集时间,格式yyyy-MM-dd hh:mm:ss.SSS
     */
    private String gmtScan;
    /**
     * 产品批次号
     */
    private String batchNo;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 产线ID
     */
    private Long productLineId;
    /**
     * 班组
     */
    private String team;
    /**
     * 创建日期，格式：yyyyMMdd
     */
    private Integer gmtDate;
    /**
     * 组织ID
     */
    private Long orgId;
    /**
     * 服务端创建时间
     */
    private String gmtCreate;
    /**
     * 服务端最后修改时间
     */
    private String gmtUpdate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEpc() {
        return epc;
    }

    public void setEpc(String epc) {
        this.epc = epc;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCodeAmount() {
        return codeAmount;
    }

    public void setCodeAmount(String codeAmount) {
        this.codeAmount = codeAmount;
    }

    public String getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(String realAmount) {
        this.realAmount = realAmount;
    }

    public String getSurplusAmount() {
        return surplusAmount;
    }

    public void setSurplusAmount(String surplusAmount) {
        this.surplusAmount = surplusAmount;
    }

    public String getGmtScan() {
        return gmtScan;
    }

    public void setGmtScan(String gmtScan) {
        this.gmtScan = gmtScan;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(Long productLineId) {
        this.productLineId = productLineId;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getGmtDate() {
        return gmtDate;
    }

    public void setGmtDate(Integer gmtDate) {
        this.gmtDate = gmtDate;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(String gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

}

