package com.baomidou.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 推流和实时转码任务关联表
 * </p>
 *
 * @author mybatis plus generator
 * @since 2022-07-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("mdc_publish_realtime_transcode")
public class PublishRealtimeTranscode implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 中间表主键ID，分布式ID填充
     */
    @TableId(value = "id", type = IdType.NONE)
    private Long id;

    /**
     * 实时转码的推流id
     */
    private Long publishId;

    /**
     * 实时转码的所属流id
     */
    private Long streamId;

    /**
     * 实时转码的流应用。只有当推流域名是企业自定义域名时，才能设置流应用。
     */
    private String streamApp;

    /**
     * 实时转码的流名。只有当推流域名是企业自定义域名时，才能设置流名。
     */
    private String streamName;

    /**
     * 实时转码的任务ID
     */
    private Long taskId;

    /**
     * 实时转码的任务状态:0为等待运行，1为运行中，2为正常而停止，3为失败而停止。
     */
    private Integer taskState;

    /**
     * 实时转码的模板ID
     */
    private Long templateId;

    /**
     * 实时转码对应的模板名称。比如：高清、标清
     */
    private String templateName;

    /**
     * 实时转码对应的模板缩写符号。比如：ld表示流畅、sd表示标清、hd表示高清、fhd表示全高清（即超清）
     */
    private String templateSymbol;

    /**
     * 实时转码的拉流源地址
     */
    private String originUrl;

    /**
     * 实时转码的目标流地址
     */
    private String targetUrl;

    /**
     * 实时转码的模板中的视频分辨率宽
     */
    private Integer width;

    /**
     * 实时转码的模板中的视频分辨率高
     */
    private Integer height;

    /**
     * 实时转码的模板中的视频码率，kbps
     */
    private Integer videoBitRate;

    /**
     * 视频码率是否跟随原片 0-不跟随 1 跟随 默认不跟随原片
     */
    private Integer videoBitRateFollow;

    /**
     * 实时转码的模板中的视频帧率，fps,视频当前只支持libxh264、libxh265、copy。可以不填
     */
    private Integer videoFrameRate;

    /**
     * 视频帧率是否跟随原片 0-不跟随 1 跟随 默认不跟随原片
     */
    private Integer videoFrameRateFollow;

    /**
     * 实时转码的模板中的视频帧率格式，视频当前只支持libxh264、libxh265、copy。可以不填
     */
    private String videoFormat;

    /**
     * 实时转码的模板中的音频码率，bps
     */
    private Integer audioBitRate;

    /**
     * 音频码率是否跟随原片 0-不跟随 1 跟随 默认不跟随原片
     */
    private Integer audioBitRateFollow;

    /**
     * 实时转码的模板中的音频声道。可以为1、2
     */
    private Integer audioChannels;

    /**
     * 实时转码的模板中的音频采样率 。默认为：48000
     */
    private Integer audioSample;

    /**
     * 实时转码的模板中的音频帧率,音频当前只支持AAC。可以不填
     */
    private String audioFormat;

    /**
     * 请求方类型。dashboard为来源于控制台、platform来源于平台
     */
    private String requesterType;

    /**
     * 当前推流对应的转码拉流地址JSON,默认包含3个拉流地址
     */
    private String pullUrls;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;


}
