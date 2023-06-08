package com.example.fastsichuan.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 物流单元关联明细表(TLogisticsCellList)表实体类
 *
 * @author makejava
 * @since 2023-06-04 17:08:49
 */
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@TableName("t_logistics_cell_list")
public class TLogisticsCellList extends Model<TLogisticsCellList> {
    //主键
    private String id;
    //物流单元id
    private Long logisticsId;
    //包装编码
    private String packingEpc;
    //关联标识{0、生产采集，1、增补，2、换入，3、换出，4、重组}
    private Integer flag;
    //组织ID
    private Long orgId;
    //服务端创建时间
    private String gmtCreate;
    //服务端最后修改时间
    private String gmtUpdate;
    //层号
    private Integer layer;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(Long logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getPackingEpc() {
        return packingEpc;
    }

    public void setPackingEpc(String packingEpc) {
        this.packingEpc = packingEpc;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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

    public Integer getLayer() {
        return layer;
    }

    public void setLayer(Integer layer) {
        this.layer = layer;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.id;
    }
    }

