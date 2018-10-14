package com.fangshuo.tempTest.graphicverification;

public class ImgConstant {
	public static String imgTexe = "package cn.lz.wisdom.parkmanager.doc;\r\n" + 
			"\r\n" + 
			"import java.util.List;\r\n" + 
			"\r\n" + 
			"import javax.servlet.http.HttpServletRequest;\r\n" + 
			"import javax.servlet.http.HttpServletResponse;\r\n" + 
			"\r\n" + 
			"import org.slf4j.Logger;\r\n" + 
			"import org.slf4j.LoggerFactory;\r\n" + 
			"import org.springframework.beans.factory.annotation.Autowired;\r\n" + 
			"import org.springframework.web.bind.annotation.RequestBody;\r\n" + 
			"import org.springframework.web.bind.annotation.RequestMapping;\r\n" + 
			"import org.springframework.web.bind.annotation.RestController;\r\n" + 
			"\r\n" + 
			"import cn.lz.cloud.common.service.ClazzNote;\r\n" + 
			"import cn.lz.cloud.common.service.ReqObject;\r\n" + 
			"import cn.lz.cloud.common.service.ReqQuery;\r\n" + 
			"import cn.lz.cloud.common.service.ResList;\r\n" + 
			"import cn.lz.cloud.common.service.ResObject;\r\n" + 
			"import cn.lz.cloud.common.service.ServiceNote;\r\n" + 
			"import cn.lz.wisdom.AccessLogManage.annotation.AccessLogger;\r\n" + 
			"import cn.lz.wisdom.doormanager.model.Building;\r\n" + 
			"import cn.lz.wisdom.doormanager.model.Door;\r\n" + 
			"import cn.lz.wisdom.parkmanager.dto.BuildingItem4APP;\r\n" + 
			"import cn.lz.wisdom.parkmanager.dto.DoorDetailDTO;\r\n" + 
			"import cn.lz.wisdom.parkmanager.dto.MenuDTO;\r\n" + 
			"import cn.lz.wisdom.parkmanager.dto.MenuDTO4APP;\r\n" + 
			"import cn.lz.wisdom.parkmanager.model.Park;\r\n" + 
			"import cn.lz.wisdom.parkmanager.param.ParkFilter;\r\n" + 
			"import cn.lz.wisdom.parkmanager.service.ParkService;\r\n" + 
			"import cn.lz.wisdom.util.EncryptionRuleCreator;\r\n" + 
			"\r\n" + 
			"/**\r\n" + 
			" * \r\n" + 
			" * @author zj\r\n" + 
			" *\r\n" + 
			" */\r\n" + 
			"@RestController\r\n" + 
			"@RequestMapping(\"/park\")\r\n" + 
			"@ClazzNote(desc = \"园区信息表\", resource = \"park\", modName = \"园区管理\")\r\n" + 
			"public class ParkController {\r\n" + 
			"	protected static final Logger log = LoggerFactory.getLogger(ParkController.class.getName());\r\n" + 
			"\r\n" + 
			"	@Autowired\r\n" + 
			"	private ParkService parkService;\r\n" + 
			"\r\n" + 
			"	// 园区开设\r\n" + 
			"	@RequestMapping(\"/create\")\r\n" + 
			"	@ServiceNote(desc = \"园区开设\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	@AccessLogger(moduleName = \"园区开设\", grade = \"0\", optionType = AccessLogger.OptionType.CREATE)\r\n" + 
			"	public ResObject<Park> create(@RequestBody ReqObject<Park> data, HttpServletRequest request,\r\n" + 
			"			HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			Park park = parkService.create(data, request);\r\n" + 
			"			return new ResObject<>(data, park);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	// 编辑园区基础信息\r\n" + 
			"	@RequestMapping(\"/update\")\r\n" + 
			"	@ServiceNote(desc = \"编辑园区基础信息\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	@AccessLogger(moduleName = \"园区信息设置\", optionType = AccessLogger.OptionType.UPD)\r\n" + 
			"	public ResObject<Park> update(@RequestBody ReqObject<Park> data, HttpServletRequest request,\r\n" + 
			"			HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			Park park = parkService.update(data, request);\r\n" + 
			"			return new ResObject<>(data, park);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	// 删除园区\r\n" + 
			"	@RequestMapping(\"/remove\")\r\n" + 
			"	@ServiceNote(desc = \"删除园区\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	@AccessLogger(moduleName = \"删除园区\", grade = \"0\", optionType = AccessLogger.OptionType.DELETE)\r\n" + 
			"	public ResObject<Integer> remove(@RequestBody ReqObject<String> data, HttpServletRequest request,\r\n" + 
			"			HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			Integer count = parkService.remove(data);\r\n" + 
			"			return new ResObject<>(data, count);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	// 查询园区列表\r\n" + 
			"	@RequestMapping(\"/retrieve\")\r\n" + 
			"	@ServiceNote(desc = \"查询园区列表[查询园区列表]\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	public ResObject<ResList<Park>> retrieve(@RequestBody ReqObject<ReqQuery<ParkFilter>> data,\r\n" + 
			"			HttpServletRequest request, HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			ResList<Park> parkList = parkService.retrieve(data);\r\n" + 
			"			return new ResObject<>(data, parkList);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	// 根据UUID查询园区信息\r\n" + 
			"	@RequestMapping(\"/get-by-uuid\")\r\n" + 
			"	@ServiceNote(desc = \"根据UUID查询园区信息\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	public ResObject<Park> selectByUuid(@RequestBody ReqObject<ParkFilter> data, HttpServletRequest request,\r\n" + 
			"			HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			Park park = parkService.selectByUuid(data);\r\n" + 
			"			return new ResObject<>(data, park);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	// 根据UUID查询园区详细信息【徐】\r\n" + 
			"	@RequestMapping(\"/getDetailByUuid\")\r\n" + 
			"	@ServiceNote(desc = \"根据UUID查询园区详细信息【徐】\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	public ResObject<Park> getDetailByUuid(@RequestBody ReqObject<String> data, HttpServletRequest request,\r\n" + 
			"			HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			Park park = parkService.findDetailByUuid(data);\r\n" + 
			"			return new ResObject<>(data, park);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	// 根据园区地址获取园区的经纬度;\r\n" + 
			"	@RequestMapping(\"/getParkLatitudebyParkAddress\")\r\n" + 
			"	@ServiceNote(desc = \"根据园区详细地址查询园区的经纬度信息\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	public ResObject<Park> getParkLatitudebyParkAddress(@RequestBody ReqObject<Park> data, HttpServletRequest request,\r\n" + 
			"			HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			Park park = parkService.getParkLatitudebyParkAddress(data);\r\n" + 
			"			return new ResObject<>(data, park);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	// 根据园区的uuid查询园区详情\r\n" + 
			"	@RequestMapping(\"/getParkDetailByParkUuid\")\r\n" + 
			"	@ServiceNote(desc = \"根据UUID查询园区信息,提供树形菜单的数据/[APP端获取园区,楼宇,楼层信息]\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	public ResObject<MenuDTO> getParkDetailByParkUuid(@RequestBody ReqObject<String> data, HttpServletRequest request,\r\n" + 
			"			HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			MenuDTO menuDTO = parkService.getParkDetailByParkUuid(data);\r\n" + 
			"			return new ResObject<>(data, menuDTO);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	@RequestMapping(\"/getParkDoorInfoByCondition\")\r\n" + 
			"	@ServiceNote(desc = \"根据条件查询园区的受控门信息/[APP端获取园区公共门信息]\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	public ResObject<ResList<DoorDetailDTO>> getParkDoorInfoByCondition(@RequestBody ReqObject<ReqQuery<Door>> data,\r\n" + 
			"			HttpServletRequest request, HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			ResList<DoorDetailDTO> parkDoorInfos = parkService.getParkDoorInfoByCondition(data);\r\n" + 
			"			return new ResObject<>(data, parkDoorInfos);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	// 根据条件查询楼宇的受控门信息\r\n" + 
			"	@RequestMapping(\"/getBuildingDoorInfoByCondition\")\r\n" + 
			"	@ServiceNote(desc = \"根据条件查询楼宇的受控门信息\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	public ResObject<ResList<DoorDetailDTO>> getBuildingDoorInfoByCondition(@RequestBody ReqObject<ReqQuery<Door>> data,\r\n" + 
			"			HttpServletRequest request, HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			ResList<DoorDetailDTO> parkDoorInfos = parkService.getBuildingDoorInfoByCondition(data);\r\n" + 
			"			return new ResObject<>(data, parkDoorInfos);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	// 根据条件查询楼层的受控门信息\r\n" + 
			"	@RequestMapping(\"/getFloorDoorInfoByCondition\")\r\n" + 
			"	@ServiceNote(desc = \"根据条件查询楼层的受控门信息/[APP端获取楼层公共门信息]\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	public ResObject<ResList<DoorDetailDTO>> getFloorDoorInfoByCondition(@RequestBody ReqObject<ReqQuery<Door>> data,\r\n" + 
			"			HttpServletRequest request, HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			ResList<DoorDetailDTO> parkDoorInfos = parkService.getFloorDoorInfoByCondition(data, request);\r\n" + 
			"			return new ResObject<>(data, parkDoorInfos);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * \r\n" + 
			"	 * @param          data:门信息列表；\r\n" + 
			"	 * @param request\r\n" + 
			"	 * @param response\r\n" + 
			"	 * @return:被开启的门的信息列表；\r\n" + 
			"	 */\r\n" + 
			"	@RequestMapping(\"/openDoorFromRomote\")\r\n" + 
			"	@ServiceNote(desc = \"远程开门【支持批量开门\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	@AccessLogger(moduleName = \"远程开门\", optionType = AccessLogger.OptionType.CREATE)\r\n" + 
			"	public ResObject<ResList<DoorDetailDTO>> openDoorFromRomote(@RequestBody ReqObject<List<DoorDetailDTO>> data,\r\n" + 
			"			HttpServletRequest request, HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			ResList<DoorDetailDTO> doorDetailDTOList = parkService.openDoorFromRomote(data, request, response);\r\n" + 
			"			return new ResObject<>(data, doorDetailDTOList);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	// 校验远程开门校验码,必须参数园区uuid和输入的校验码信息\r\n" + 
			"	@RequestMapping(\"/checkRemotevVerificationCode\")\r\n" + 
			"	@ServiceNote(desc = \"校验远程开门校验码\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	public ResObject<Boolean> checkRemotevVerificationCode(@RequestBody ReqObject<Park> data,\r\n" + 
			"			HttpServletRequest request, HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			Boolean isLegal = parkService.checkRemotevVerificationCode(data, request);\r\n" + 
			"			return new ResObject<>(data, isLegal);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	// 校验远程开门校验码,必须参数园区uuid和输入的校验码信息\r\n" + 
			"	@RequestMapping(\"/checkRemotevVerCode4App\")\r\n" + 
			"	@ServiceNote(desc = \"校验远程开门校验码[4APP]\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	public ResObject<MenuDTO4APP> checkRemotevVerCode4App(@RequestBody ReqObject<Park> data, HttpServletRequest request,\r\n" + 
			"			HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			MenuDTO4APP isLegal = parkService.checkRemotevVerCode4App(data, request);\r\n" + 
			"			return new ResObject<>(data, isLegal);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	// 根据楼宇的uuid查询楼宇的详细信息【包含楼层信息和公共门的信息[4APP]】\r\n" + 
			"	@RequestMapping(\"/getBuildingDetailByUuid\")\r\n" + 
			"	@ServiceNote(desc = \"根据楼宇的uuid查询楼宇的详细信息【包含楼层信息和公共门的信息[4APP]】\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	public ResObject<BuildingItem4APP> getBuildingDetailByUuid(@RequestBody ReqObject<Building> data,\r\n" + 
			"			HttpServletRequest request, HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			BuildingItem4APP result = parkService.getBuildingDetailByUuid(data, request);\r\n" + 
			"			return new ResObject<>(data, result);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	// 根据条件查询下拉选项框的数据;\r\n" + 
			"	@RequestMapping(\"/retrieve_disable\")\r\n" + 
			"	@ServiceNote(desc = \"根据条件查询下拉选项框的数据[已禁用];\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	public ResObject<ResList<Park>> getSelectorByCOndition(@RequestBody ReqObject<ReqQuery<ParkFilter>> data,\r\n" + 
			"			HttpServletRequest request, HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			ResList<Park> parkList = parkService.getSelectorByCOndition(data, request);\r\n" + 
			"			return new ResObject<>(data, parkList);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	@RequestMapping(\"/getEncryptionRuleWithOrder\")\r\n" + 
			"	@ServiceNote(desc = \"获取加密规则;\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	public ResObject<List<Integer>> getEncryptionRuleWithOrder(HttpServletRequest request,\r\n" + 
			"			HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			List<Integer> encryptionRule = EncryptionRuleCreator.getEncryptionRule();\r\n" + 
			"			// ResList<Integer> resList = new ResList<Integer>(encryptionRule);\r\n" + 
			"			return new ResObject<>(null, encryptionRule);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(null, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	// 根据园区的条件查询时间戳【加密规则】\r\n" + 
			"	@RequestMapping(\"/getEncryptionRuleByCondition\")\r\n" + 
			"	@ServiceNote(desc = \"根据园区的条件查询时间戳【加密规则】\", auth = ServiceNote.AUTH.CHECK)\r\n" + 
			"	public ResObject<Park> getEncryptionRuleByCondition(@RequestBody ReqObject<ParkFilter> data,\r\n" + 
			"			HttpServletRequest request, HttpServletResponse response) {\r\n" + 
			"		try {\r\n" + 
			"			Park parkWithEncryptionRule = parkService.getEncryptionRuleByCondition(data);\r\n" + 
			"			return new ResObject<>(data, parkWithEncryptionRule);\r\n" + 
			"		} catch (Exception e) {\r\n" + 
			"			return new ResObject<>(data, e);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"}\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"package cn.lz.wisdom.parkmanager.doc;\r\n" + 
			"\r\n" + 
			"import java.util.List;\r\n" + 
			"\r\n" + 
			"import javax.servlet.http.HttpServletRequest;\r\n" + 
			"import javax.servlet.http.HttpServletResponse;\r\n" + 
			"import javax.servlet.http.HttpSession;\r\n" + 
			"\r\n" + 
			"import org.slf4j.Logger;\r\n" + 
			"import org.slf4j.LoggerFactory;\r\n" + 
			"import org.springframework.beans.factory.annotation.Autowired;\r\n" + 
			"import org.springframework.data.mongodb.core.MongoTemplate;\r\n" + 
			"import org.springframework.stereotype.Service;\r\n" + 
			"import org.springframework.transaction.annotation.Isolation;\r\n" + 
			"import org.springframework.transaction.annotation.Propagation;\r\n" + 
			"import org.springframework.transaction.annotation.Transactional;\r\n" + 
			"\r\n" + 
			"import cn.lz.cloud.common.service.ReqObject;\r\n" + 
			"import cn.lz.cloud.common.service.ReqQuery;\r\n" + 
			"import cn.lz.cloud.common.service.ResList;\r\n" + 
			"import cn.lz.cloud.common.util.DateUtil;\r\n" + 
			"import cn.lz.cloud.common.util.UUID;\r\n" + 
			"import cn.lz.conf.rabbitmq.Sender;\r\n" + 
			"import cn.lz.wisdom.constant.ErrMsgConstant;\r\n" + 
			"import cn.lz.wisdom.doormanager.dao.BuildingMapper;\r\n" + 
			"import cn.lz.wisdom.doormanager.dao.DoorMapper;\r\n" + 
			"import cn.lz.wisdom.doormanager.dao.UserDoorMapper;\r\n" + 
			"import cn.lz.wisdom.doormanager.model.Building;\r\n" + 
			"import cn.lz.wisdom.doormanager.model.Door;\r\n" + 
			"import cn.lz.wisdom.entrancelog.dao.EntranceLogMapper;\r\n" + 
			"import cn.lz.wisdom.enums.ActiveEnum;\r\n" + 
			"import cn.lz.wisdom.login.model.UserInfo;\r\n" + 
			"import cn.lz.wisdom.login.model.WpSessionData;\r\n" + 
			"import cn.lz.wisdom.menumanager.model.Menu;\r\n" + 
			"import cn.lz.wisdom.parkmanager.dao.ParkMapper;\r\n" + 
			"import cn.lz.wisdom.parkmanager.dto.BuildingItem4APP;\r\n" + 
			"import cn.lz.wisdom.parkmanager.dto.DoorDetailDTO;\r\n" + 
			"import cn.lz.wisdom.parkmanager.dto.MenuDTO;\r\n" + 
			"import cn.lz.wisdom.parkmanager.dto.MenuDTO4APP;\r\n" + 
			"import cn.lz.wisdom.parkmanager.dto.ParkStatisticDTO;\r\n" + 
			"import cn.lz.wisdom.parkmanager.model.Park;\r\n" + 
			"import cn.lz.wisdom.parkmanager.param.ParkFilter;\r\n" + 
			"import cn.lz.wisdom.parkmanager.service.ParkService;\r\n" + 
			"import cn.lz.wisdom.queue.model.EncryptionRule;\r\n" + 
			"import cn.lz.wisdom.sequence.dao.WisdomSeqMapper;\r\n" + 
			"import cn.lz.wisdom.util.GeoMapUtils;\r\n" + 
			"\r\n" + 
			"/**\r\n" + 
			" * \r\n" + 
			" * @author zj 园区信息表\r\n" + 
			" *\r\n" + 
			" */\r\n" + 
			"@Service\r\n" + 
			"public class ParkServiceImpl implements ParkService {\r\n" + 
			"	protected static final Logger log = LoggerFactory.getLogger(ParkServiceImpl.class.getName());\r\n" + 
			"	\r\n" + 
			"@Autowired\r\n" + 
			"	protected ParkMapper parkMapper;\r\n" + 
			"	@Autowired\r\n" + 
			"	protected Sender sender;\r\n" + 
			"\r\n" + 
			"	@Autowired\r\n" + 
			"	protected MongoTemplate mongoTemplate;\r\n" + 
			"\r\n" + 
			"	@Autowired\r\n" + 
			"	protected DoorMapper doorMapper;\r\n" + 
			"\r\n" + 
			"	@Autowired\r\n" + 
			"	protected BuildingMapper buildingMapper;\r\n" + 
			"\r\n" + 
			"	@Autowired\r\n" + 
			"	protected WisdomSeqMapper wisdomSeqMapper;\r\n" + 
			"\r\n" + 
			"	@Autowired\r\n" + 
			"	protected UserDoorMapper userDoorMapper;\r\n" + 
			"\r\n" + 
			"	@Autowired\r\n" + 
			"	protected EntranceLogMapper entranceLogMapper;\r\n" + 
			"\r\n" + 
			"	protected static final String LONGITUDE = \"longitude\";// 经度类型;\r\n" + 
			"	protected static final String LATITUDE = \"latitude\";// 纬度类型;\r\n" + 
			"	protected static final String WEB_TYPE = \"WEB\";// 应用类型【web】;\r\n" + 
			"	protected static final String APP_TYPE = \"APP\";// 应用类型【app】;\r\n" + 
			"	protected static final String OP_TYPE_UPDATE = \"update\";// 操作类型类型【更新】;\r\n" + 
			"	protected static final String OP_TYPE_CREATE = \"create\";// 操作类型类型【创建】;\r\n" + 
			"	protected static final String LOGIN_TYPE_4_WEB = \"WEB_LOGIN\";// 登录类型【web端登录】;\r\n" + 
			"	protected static final String LOGIN_TYPE_4APP = \"APP_LOGIN\";// 登录类型【app端登录】;\r\n" + 
			"	protected static final String DEFAULT_FLOW_NO = \"1\";// 远程开门APP端默认选中的楼层自然编号;\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 园区开设\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)\r\n" + 
			"	public Park create(ReqObject<Park> data, HttpServletRequest request) {\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 编辑园区基础信息\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)\r\n" + 
			"	public Park update(ReqObject<Park> data, HttpServletRequest request) {\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 删除园区\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)\r\n" + 
			"	public Integer remove(ReqObject<String> uuid) {\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 查询园区列表\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)\r\n" + 
			"	public ResList<Park> retrieve(ReqObject<ReqQuery<ParkFilter>> filter) {\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 根据UUID查询园区信息\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)\r\n" + 
			"	public Park selectByUuid(ReqObject<ParkFilter> data) {\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 根据UUID查询园区详细信息【徐】\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)\r\n" + 
			"	public Park findDetailByUuid(ReqObject<String> data) {\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 根据条件更新园区标志图片;\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	public Integer updateParkSymbolFile(ReqObject<Park> parkFilter) {\r\n" + 
			"		// TODO Auto-generated method stub\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 根据UUID查询园区信息,提供树形菜单的数据\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)\r\n" + 
			"	public MenuDTO getParkDetailByParkUuid(ReqObject<String> data) {\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 根据条件查询园区的受控门信息\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	@Transactional(isolation = Isolation.READ_UNCOMMITTED, propagation = Propagation.REQUIRED)\r\n" + 
			"	public ResList<DoorDetailDTO> getParkDoorInfoByCondition(ReqObject<ReqQuery<Door>> data) {\r\n" + 
			"		// TODO Auto-generated method stub\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 根据条件查询园区的受控门信息\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	public ResList<DoorDetailDTO> getBuildingDoorInfoByCondition(ReqObject<ReqQuery<Door>> data) {\r\n" + 
			"		// TODO Auto-generated method stub\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 根据条件查询楼层的受控门信息\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	public ResList<DoorDetailDTO> getFloorDoorInfoByCondition(ReqObject<ReqQuery<Door>> data,\r\n" + 
			"			HttpServletRequest request) {\r\n" + 
			"		// TODO Auto-generated method stub\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 远程开门【支持批量开门】\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	public ResList<DoorDetailDTO> openDoorFromRomote(ReqObject<List<DoorDetailDTO>> data, HttpServletRequest request,\r\n" + 
			"			HttpServletResponse response) {\r\n" + 
			"		// TODO Auto-generated method stub\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 校验远程开门校验码\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	public Boolean checkRemotevVerificationCode(ReqObject<Park> data, HttpServletRequest request) {\r\n" + 
			"		// TODO Auto-generated method stub\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 根据条件查询下拉选项框的数据;\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	public ResList<Park> getSelectorByCOndition(ReqObject<ReqQuery<ParkFilter>> filter, HttpServletRequest request) {\r\n" + 
			"		// TODO Auto-generated method stub\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 校验园区App验证码[4APP];\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	public MenuDTO4APP checkRemotevVerCode4App(ReqObject<Park> data, HttpServletRequest request) {\r\n" + 
			"		// TODO Auto-generated method stub\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 根据楼宇的uuid查询楼宇的详细信息【包含楼层信息和公共门的信息[4APP]】\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	public BuildingItem4APP getBuildingDetailByUuid(ReqObject<Building> data, HttpServletRequest request) {\r\n" + 
			"		// TODO Auto-generated method stub\r\n" + 
			"		return null;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 根据园区地址获取园区的经纬度;\r\n" + 
			"	 */\r\n" + 
			"	@Override\r\n" + 
			"	public Park getParkLatitudebyParkAddress(ReqObject<Park> data) {\r\n" + 
			"		// TODO Auto-generated method stub\r\n" + 
			"		Park park = data.getObject();\r\n" + 
			"		String parkLocation = park.getParkLocation();\r\n" + 
			"		if (parkLocation == null || \"\".equals(parkLocation)) {\r\n" + 
			"			parkLocation = \"\";\r\n" + 
			"		}\r\n" + 
			"		String parkAddress = park.getParkAddress();\r\n" + 
			"		if (parkAddress == null || \"\".equals(parkAddress)) {\r\n" + 
			"			parkAddress = \"\";\r\n" + 
			"		}\r\n" + 
			"		String detailAddress = parkLocation + parkAddress;\r\n" + 
			"		String parkLatitude = GeoMapUtils.getLocation(detailAddress);\r\n" + 
			"		String[] latitudeStrArray = parkLatitude.split(\",\");\r\n" + 
			"		// 最终的经度;\r\n" + 
			"		String reallLongitude = getFormatLatitudebyNumStr(latitudeStrArray[0], LONGITUDE);\r\n" + 
			"		// 最终的纬度;\r\n" + 
			"		String reallLatitude = getFormatLatitudebyNumStr(latitudeStrArray[1], LATITUDE);\r\n" + 
			"		// 最终的经纬度;\r\n" + 
			"		parkLatitude = reallLongitude + \",\" + reallLatitude;\r\n" + 
			"		park.setParkLatitude(parkLatitude);\r\n" + 
			"		return park;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * \r\n" + 
			"	 * @param numStr:根据数字字符串获取格式化的经纬度;\r\n" + 
			"	 * @param type:转化类型;\r\n" + 
			"	 * @return\r\n" + 
			"	 */\r\n" + 
			"	public String getFormatLatitudebyNumStr(String numStr, String locatedType) {\r\n" + 
			"		String finalResult = \"\";\r\n" + 
			"		int precision = numStr.indexOf(\".\");// 度的精度;\r\n" + 
			"		// 度数;\r\n" + 
			"		String degree = numStr.substring(0, precision) + \"°\";// 度数;\r\n" + 
			"		// 分数;\r\n" + 
			"		String pointNumStr = Double.valueOf(\"0.\" + numStr.substring(precision + 1)) * 60 + \"\";// 分数的字符串;\r\n" + 
			"		int pointPrecision = pointNumStr.indexOf(\".\");// 分的精度;\r\n" + 
			"		String point = pointNumStr.substring(0, pointPrecision) + \"′\";\r\n" + 
			"		// 秒数;\r\n" + 
			"		String secondNumStr = Double.valueOf(\"0.\" + pointNumStr.substring(pointPrecision + 1)) * 60 + \"\";// 分数;\r\n" + 
			"		int secondPrecision = secondNumStr.indexOf(\".\");// 秒的精度;\r\n" + 
			"		String second = secondNumStr.substring(0, secondPrecision) + \"′′\";\r\n" + 
			"		// 最终的经度或纬度;\r\n" + 
			"		finalResult = degree + point + second;\r\n" + 
			"		if (LONGITUDE.equals(locatedType)) {\r\n" + 
			"			finalResult += \"E\";\r\n" + 
			"		} else {\r\n" + 
			"			finalResult += \"N\";\r\n" + 
			"		}\r\n" + 
			"		return finalResult;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 判断该园区下是否有关联的企业和员工;\r\n" + 
			"	 * \r\n" + 
			"	 * @param targetUuid\r\n" + 
			"	 */\r\n" + 
			"	public void isRelatedToCompanyOrStaff(String targetUuid) {\r\n" + 
			"		Integer isRelatedToCompanyOrStaff = parkMapper.isRelatedToUserOrCompany(targetUuid);\r\n" + 
			"		if (isRelatedToCompanyOrStaff > 0) {\r\n" + 
			"			throw ErrMsgConstant.PARK_DEL_PRE_CONDITION.exception();\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 检查用户是否具有远程开门的权限;\r\n" + 
			"	 * \r\n" + 
			"	 * @param request\r\n" + 
			"	 * @param requiredAuth\r\n" + 
			"	 * @return\r\n" + 
			"	 */\r\n" + 
			"	public Boolean isOwnPerm4OPeration(HttpServletRequest request, String requiredAuth) {\r\n" + 
			"		Boolean isAuthEnough = false;\r\n" + 
			"		WpSessionData wpSessionData = (WpSessionData) request.getSession().getAttribute(\"user\");\r\n" + 
			"		UserInfo userInfo = wpSessionData.getUserInfo();\r\n" + 
			"		List<Menu> menus = userInfo.getMenus();\r\n" + 
			"\r\n" + 
			"		if (menus != null && menus.size() > 0) {// 管理后台超级管理员和园区管理员登录;\r\n" + 
			"			if (null != userInfo.getParkUuid()) {// 园区门禁管理员\r\n" + 
			"				for (Menu menu : menus) {\r\n" + 
			"					if (null != menu) {\r\n" + 
			"						if (requiredAuth.equals(menu.getName())) {\r\n" + 
			"							isAuthEnough = true;\r\n" + 
			"							break;\r\n" + 
			"						}\r\n" + 
			"					}\r\n" + 
			"				}\r\n" + 
			"			} else if (null == userInfo.getParkUuid()) {\r\n" + 
			"				isAuthEnough = true;\r\n" + 
			"			}\r\n" + 
			"		} else {// APP端园区管理员登录;\r\n" + 
			"			isAuthEnough = true;\r\n" + 
			"		}\r\n" + 
			"\r\n" + 
			"		return isAuthEnough;\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	/**\r\n" + 
			"	 * 发送校验码生成规则到消息队列；\r\n" + 
			"	 * \r\n" + 
			"	 * @param encryptionRule：校验码规则字符串;\r\n" + 
			"	 */\r\n" + 
			"	public void sendEncryptionRuleToRBQ(Park newPark, String opType) {\r\n" + 
			"		// TODO Auto-generated method stub\r\n" + 
			"		String parkUuid = newPark.getUuid();\r\n" + 
			"		String encryptionRule = newPark.getEncryptionRule();\r\n" + 
			"\r\n" + 
			"		// 更新时判加密规则是否发生了变化;\r\n" + 
			"		if (OP_TYPE_UPDATE.equals(opType)) {\r\n" + 
			"			ParkFilter qry = new ParkFilter();\r\n" + 
			"			qry.setActive(ActiveEnum.ACTIVE_EXIST.getActive());\r\n" + 
			"			qry.setUuid(parkUuid);\r\n" + 
			"			// String parkUuid = qry.getUuid();\r\n" + 
			"			List<Park> parkList = parkMapper.selectByPrimaryKey(qry);\r\n" + 
			"			if (parkList != null && parkList.size() > 0) {\r\n" + 
			"				Park oldPark = parkList.get(0);\r\n" + 
			"				String oldEncryptionRule = oldPark.getEncryptionRule();\r\n" + 
			"				if (!oldEncryptionRule.equals(encryptionRule)) {\r\n" + 
			"					sendAndConvertERToRBQ(newPark);\r\n" + 
			"				}\r\n" + 
			"			}\r\n" + 
			"		} else if (OP_TYPE_CREATE.equals(opType)) {\r\n" + 
			"			// 发送数据到消息队列;\r\n" + 
			"			sendAndConvertERToRBQ(newPark);\r\n" + 
			"		}\r\n" + 
			"\r\n" + 
			"	}\r\n" + 
			"\r\n" + 
			"	public void sendAndConvertERToRBQ(Park newPark) {\r\n" + 
			"		EncryptionRule encryptionRuleEntity = new EncryptionRule();\r\n" + 
			"	encryptionRuleEntity.setEncryptionRuleList(newPark.getEncryptionRuleList());		encryptionRuleEntity.setFlowNo(UUID.getUUID());// 流水号;\r\n" + 
			"		// 发送数据到消息队列;\r\n" + 
			"		sender.sendEncryptionRuleQueue(encryptionRuleEntity);\r\n" + 
			"	}\r\n" + 
			"}";
}