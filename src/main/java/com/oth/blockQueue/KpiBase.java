/**
 * @Title: Kpi.java
 * @Package cn.com.testplatform.engine.base.kpi
 * @Description: 指标类
 * @author zhangtianhai
 * @date 2015年12月7日 下午5:29:28
 * @version V1.0
 */
package com.oth.blockQueue;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Abstract Kpi TODO 之后将KPI模型分成2组 ，一组用于缓存
 *             TestResult中的结果数据（属于基础模型），然后可以用缓冲池的方式， 另一种跟现在的模型一致，用于计算
 * @Description: 指标类
 * @author zhangtianhai
 * @date 2015年12月7日 下午5:29:28
 */
public class KpiBase implements Cloneable {

	/**
	 * @Fields id
	 * @author zhangtianhai
	 */
	private int id;

	/**
	 * 参数的类型
	 */
	private byte kpi_0;

	/**
	 * 次数Count<br>
	 * 这里不能默认为1了，新增加了点击数，当发送请求的时候设置，此时这里不应该是1，应该是0 了
	 */
	private int kpi_001 = 0;
	/**
	 * 错误数 ErrorCount
	 */
	private int kpi_002 = 0;
	/**
	 * 错误码统计 ErrorCodeCount
	 */
	private Map<Short, Integer> kpi_004 = new HashMap<Short, Integer>();
	/**
	 * 成功数 SuccessCount
	 */
	private int kpi_007 = 0;
	/**
	 * 请求响应数 ResponseCount
	 */
	private int kpi_008 = 0;
	/**
	 * 错误总数 FailNum
	 */
	private int kpi_009 = 0;
	/**
	 * 结果成功标记 successFlag
	 */
	private int kpi_010 = 0;

	/**
	 * 点击数：发送请求的时候设置
	 */
	private int kpi_011 = 0;

	/**
	 * @Fields 告警次数
	 * @author zhangtianhai
	 */
	private int kpi_012 = 0;

	/**
	 * 检查点总数
	 * */
	private Map<String, Integer> kpi_019 = new HashMap<String, Integer>();

	/**
	 * 检查点失败数
	 * */
	private Map<String, Integer> kpi_020 = new HashMap<String, Integer>();

	/**
	 * 检查点成功数
	 */
	private Map<String, Integer> kpi_021 = new HashMap<String, Integer>();

	/**
	 * 发送字节(MB) Sendbytes
	 */
	private double kpi_101 = 0;
	/**
	 * 接收字节(MB) Recvbytes
	 */
	private double kpi_102 = 0;
	/**
	 * 总处理时长 Duration
	 */
	private double kpi_111 = 0;
	/**
	 * 最小处理时长 MinDuration
	 */
	private double kpi_112 = 0;
	/**
	 * 最大处理时长 kpi_113
	 */
	private double kpi_113 = 0;
	/**
	 * 90%平均处理时长(秒) Avg90ResponseTime
	 */
	private double kpi_301 = 0;

	/**
	 * 每秒点击数
	 */
	private int kpi_003;
	/**
	 * 叶子节点的次数
	 */
	private int kpi_006;
	/**
	 * 叶子节点处理时长
	 */
	private double kpi_118;

	private int userThreadIndex;
	/**
	 * 用户线程名
	 */
	private String userThreadName;
	/**
	 * 区域
	 */
	private String exeArea;
	/**
	 * 消息码
	 */
	private String responseCode;

	/**
	 * @Fields 异步连接接收消息数
	 */
	private long kpi_022 = 0;

	/**
	 * 异步连接接收消息数
	 */
	private int kpi_023 = 0;

	/**
	 * @Description: 初始化
	 * @author majunjun
	 * @date 2015年12月7日 下午6:00:43
	 * @version V1.0
	 */
	public void clear() {
		this.id = 0;
		this.kpi_0 = 0;
		this.kpi_001 = 0;
		this.kpi_002 = 0;
		this.kpi_004.clear();
		this.kpi_007 = 0;
		this.kpi_008 = 0;
		this.kpi_009 = 0;
		this.kpi_010 = 0;
		this.kpi_011 = 0;
		this.kpi_012 = 0;
		this.kpi_019.clear();
		this.kpi_020.clear();
		this.kpi_021.clear();
		this.kpi_101 = 0;
		this.kpi_102 = 0;
		this.kpi_111 = 0;
		this.kpi_112 = 0;
		this.kpi_113 = 0;
		this.kpi_301 = 0;
		this.kpi_003 = 0;
		this.kpi_006 = 0;
		this.kpi_118 = 0;
		this.kpi_022 = 0;
		this.kpi_023 = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getKpi_0() {
		return kpi_0;
	}

	public void setKpi_0(byte kpi_0) {
		this.kpi_0 = kpi_0;
	}

	public int getKpi_001() {
		return kpi_001;
	}

	public void setKpi_001(int kpi_001) {
		this.kpi_001 = kpi_001;
	}

	public int getKpi_002() {
		return kpi_002;
	}

	public void setKpi_002(int kpi_002) {
		this.kpi_002 = kpi_002;
	}

	public Map<Short, Integer> getKpi_004() {
		return kpi_004;
	}

	public void setKpi_004(Map<Short, Integer> kpi_004) {
		this.kpi_004 = kpi_004;
	}

	public int getKpi_007() {
		return kpi_007;
	}

	public void setKpi_007(int kpi_007) {
		this.kpi_007 = kpi_007;
	}

	public int getKpi_008() {
		return kpi_008;
	}

	public void setKpi_008(int kpi_008) {
		this.kpi_008 = kpi_008;
	}

	public int getKpi_009() {
		return kpi_009;
	}

	public void setKpi_009(int kpi_009) {
		this.kpi_009 = kpi_009;
	}

	public int getKpi_010() {
		return kpi_010;
	}

	public void setKpi_010(int kpi_010) {
		this.kpi_010 = kpi_010;
	}

	/**
	 * @return kpi_011
	 */
	public int getKpi_011() {
		return kpi_011;
	}

	/**
	 * @param kpi_011
	 */
	public void setKpi_011(int kpi_011) {
		this.kpi_011 = kpi_011;
	}

	/**
	 * @return kpi_012
	 */
	public int getKpi_012() {
		return kpi_012;
	}

	public Map<String, Integer> getKpi_019() {
		return kpi_019;
	}

	public void setKpi_019(Map<String, Integer> kpi_019) {
		this.kpi_019 = kpi_019;
	}

	public Map<String, Integer> getKpi_020() {
		return kpi_020;
	}

	public void setKpi_020(Map<String, Integer> kpi_020) {
		this.kpi_020 = kpi_020;
	}

	public Map<String, Integer> getKpi_021() {
		return kpi_021;
	}

	public void setKpi_021(Map<String, Integer> kpi_021) {
		this.kpi_021 = kpi_021;
	}

	/**
	 * @param kpi_012
	 */
	public void setKpi_012(int kpi_012) {
		this.kpi_012 = kpi_012;
	}

	public double getKpi_101() {
		return kpi_101;
	}

	public void setKpi_101(double kpi_101) {
		this.kpi_101 = kpi_101;
	}

	public double getKpi_102() {
		return kpi_102;
	}

	public void setKpi_102(double kpi_102) {
		this.kpi_102 = kpi_102;
	}

	public double getKpi_111() {
		return kpi_111;
	}

	public void setKpi_111(double kpi_111) {
		this.kpi_111 = kpi_111;
	}

	public double getKpi_112() {
		return kpi_112;
	}

	public void setKpi_112(double kpi_112) {
		this.kpi_112 = kpi_112;
	}

	public double getKpi_113() {
		return kpi_113;
	}

	public void setKpi_113(double kpi_113) {
		this.kpi_113 = kpi_113;
	}

	public double getKpi_301() {
		return kpi_301;
	}

	public void setKpi_301(double kpi_301) {
		this.kpi_301 = kpi_301;
	}

	public int getKpi_003() {
		return kpi_003;
	}

	public void setKpi_003(int kpi_003) {
		this.kpi_003 = kpi_003;
	}

	public int getKpi_006() {
		return kpi_006;
	}

	public void setKpi_006(int kpi_006) {
		this.kpi_006 = kpi_006;
	}

	public double getKpi_118() {
		return kpi_118;
	}

	public void setKpi_118(double kpi_118) {
		this.kpi_118 = kpi_118;
	}

	public String getUserThreadName() {
		return userThreadName;
	}

	public void setUserThreadName(String userThreadName) {
		this.userThreadName = userThreadName;
	}

	public String getExeArea() {
		return exeArea;
	}

	public void setExeArea(String exeArea) {
		this.exeArea = exeArea;
	}

	public int getUserThreadIndex() {
		return userThreadIndex;
	}

	public void setUserThreadIndex(int userThreadIndex) {
		this.userThreadIndex = userThreadIndex;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	@Override
	public KpiBase clone() {
		KpiBase kpi;
		try {
			kpi = (KpiBase) super.clone();
			HashMap<Short, Integer> map = new HashMap<Short, Integer>();
			map.putAll(this.getKpi_004());
			kpi.setKpi_004(map);
			Map<String, Integer> map019 = new HashMap<String, Integer>();
			map019.putAll(this.getKpi_019());
			kpi.setKpi_019(map019);
			Map<String, Integer> map020 = new HashMap<String, Integer>();
			map020.putAll(this.getKpi_020());
			kpi.setKpi_020(map020);
			Map<String, Integer> map021 = new HashMap<String, Integer>();
			map021.putAll(map021);
			kpi.setKpi_021(map021);
		} catch (CloneNotSupportedException e) {
			kpi = new KpiBase();
		}
		return kpi;
	}

	public String tojson() {
		JSONObject json = (JSONObject) JSONObject.toJSON(this);
		return json.toString();
	}

	/**
	 * @Description: 用于打印的字符串，不使用json，减少打印量
	 * @author zhangtianhai
	 * @date 2016年5月6日 上午8:26:05
	 * @version V1.0
	 * @return
	 */

	public long getKpi_022() {
		return kpi_022;
	}

	public void setKpi_022(long kpi_022) {
		this.kpi_022 = kpi_022;
	}

	public int getKpi_023() {
		return kpi_023;
	}

	public void setKpi_023(int kpi_023) {
		this.kpi_023 = kpi_023;
	}

	public void calc(KpiBase kpi) {
		// 总次数相加
		this.setKpi_001(this.getKpi_001() + kpi.getKpi_001());
		// 错误数相加
		this.setKpi_002(this.getKpi_002() + kpi.getKpi_002());
		// 错误码统计
		// 成功数相加
		this.setKpi_007(this.getKpi_007() + kpi.getKpi_007());
		// 请求响应数
		this.setKpi_008(this.getKpi_008() + kpi.getKpi_008());
		// 错误总数
		this.setKpi_009(this.getKpi_009() + kpi.getKpi_009());
		// 点击数
		this.setKpi_011(this.getKpi_011() + kpi.getKpi_011());
		// 告警次数
		this.setKpi_012(this.getKpi_012() + kpi.getKpi_012());
		// 检查点总数
		// 发送字节(MB)
		this.setKpi_101(this.getKpi_101() + kpi.getKpi_101());
		// 接收字节(MB)
		this.setKpi_102(this.getKpi_102() + kpi.getKpi_102());
		// 总处理时长
		this.setKpi_111(this.getKpi_111() + kpi.getKpi_111());
		// 如果过来的比当前的小，则更新，否则保持原来的（即原来的是最小的）
		if (kpi.getKpi_112() > 0 && (kpi.getKpi_112() < this.getKpi_112() || this.getKpi_112() == 0)) {
			this.setKpi_112(kpi.getKpi_112());
		}
		// 最大处理时间比较
		// 如果过来的比当前的大，则更新，否则保持原来的（即原来的是最大的）
		if (kpi.getKpi_113() > this.getKpi_113()) {
			this.setKpi_113(kpi.getKpi_113());
		}
		// 当前这个111里面是所有成功的处理时间的和，除以成功的个数
	}
}
