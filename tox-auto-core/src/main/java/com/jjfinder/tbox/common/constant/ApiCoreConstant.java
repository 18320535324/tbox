package com.jjfinder.tbox.common.constant;

import java.util.HashSet;

/**
 * Created by bukp on 2018/1/5 16:03.
 */
public class ApiCoreConstant {
    public static  HashSet<String> authSet;


    //区域
    public static final String DISTRICT = "/district";
    public static final String DISTRICT_QUERY_LEVEL = "/query/districtLevelByPid";
    //查询所有市区 根据首字母分组
    public static final String DISTRICT_QUERY_CITY_BY_SUFFIX = "/query/districtCityBySuffixGroup";

    // 新建活动的场景定向，使用公共接口数据
    public static final String DISTRICT_QUERY_LEVEL_BASIC = "/query/districtLevelByPid/basic";

    //场所
    public static final String SCENE = "/scene";
    public static final String SCENE_QUERY_LEVEL = "/query/sceneLevelByPcode";

    // *****************************************************************************************************************
    // 设备
    public static final String DEVICE = "/device";

    // 导入设备
    public static final String IMPORT = "/import";

    // 绑定设备
    public static final String DEVICE_BOUND = "/bound";

    // 解绑设备
    public static final String DEVICE_UNBOUND = "/unbound";

    // 根据商户查询设备
    public static final String DEVICE_QUERY_MERCHANT_DEVICE ="/query/merchantDevice";
    //查询黑盒设备
    public static final String DEVICE_QUERY_ALL_DEVICE ="/query/allDevice";
    //查询黑盒状态统计
    public static final String DEVICE_QUERY_DEVICE_COUNT ="/query/deviceCount";
    //查询mac数据
    public static final String DEVICE_QUERY_MAC_DATA ="/query/macData";
    //商户平台查询mac数据
    public static final String DEVICE_QUERY_MERCHANT_MAC_DATA ="/query/merchant/macData";

    // *****************************************************************************************************************

    // 统计
    public static final String STATISTICS = "/statistics";

    public static final String STATISTICS_FLOW_BASIC4 = "/flow/basic4/{merchantId}";

    // 1.0.1
    // 附近客流统计数值
    public static final String STATISTICS_FLOW_BASIC = "/flow/basic";
    public static final String STATISTICS_FLOW_BASIC_YESTERDAY = "/flow/basicYesterday";
    // 新老客分析数值
    public static final String STATISTICS_NEW_FLOW_BASIC = "/flow/new/basic";
    // 转化客流分析数值
    public static final String STATISTICS_SALE_FLOW_BASIC = "/flow/sale/basic";
    // 活动统计数值
    public static final String STATISTICS_ACTIVITY_FLOW_BASIC = "/flow/activity/basic";
    // 总览页相关数值
    public static final String STATISTICS_OVERVIEW_FLOW_BASIC = "/flow/overview/basic";
    // 总览页账户相关数值
    public static final String STATISTICS_OVERVIEW_ACCOUNT= "/flow/overview/account";


    // 区间统计，今日客流
    public static final String STATISTICS_FLOW_SECTION_HOUR_TODAY = "/flow/section/todayhours/{merchantId}";
    // 区间统计，昨日客流
    public static final String STATISTICS_FLOW_SECTION_HOUR_YESTERDAY = "/flow/section/yesterdayhours";
    // 附近客流统计，选择日期范围
    public static final String STATISTICS_FLOW_SECTION_DAYS = "/flow/section/days";
    // 新老客流趋势图
    public static final String STATISTICS_NEW_FLOW_SECTION_DAYS = "/flow/new/section/days";
    // 营销到店人数趋势图
    public static final String STATISTICS_SALE_INSIDE_FLOW_SECTION_DAYS = "/flow/sale/inside/section/days";
    // 发放统计趋势图
    public static final String STATISTICS_SEND_FLOW_SECTION_DAYS = "/flow/send/section/days";
    // 总览页趋势图
    public static final String STATISTICS_OVERVIEW_FLOW_SECTION_DAYS = "/flow/overview/section/days";
    //运营总览相关统计值
    public static final String STATISTICS_OVERVIEW_FLOW_OPERTATE_STAT_DATA = "/flow/overview/operateStat";
    //查询门店统计趋势图
    public static final String STATISTICS_OVERVIEW_FLOW_OPERTATE_STORE_STAT = "/flow/overview/operateStoreStat";
    //查看活动消耗统计纬度图
    public static final String STATISTICS_OVERVIEW_FLOW_OPERTATE_ACTIVITYCONSUMER_STAT = "/flow/overview/operateActivityConsumerStat";
    //查看活动消耗统计户均纬度图
    public static final String STATISTICS_OVERVIEW_FLOW_OPERTATE_ACTIVITYCONSUMER_AVG_STAT = "/flow/overview/operateActivityConsumerStatAvg";

    //广告渠道页面总览数值
    public static final String STATISTICS_ACTIVITY_OVERVIEW_BASIC = "/activity/overview/basic";


    // *****************************************************************************************************************
    // 账户
    public static final String ACCOUNT = "/account";
    //登出
    public static final String AUTH_LOG_OUT = "/logout";
    //查询所有账户
    public static final String ACCOUNT_QUERY_ALL_ACCOUNT = "/query/allAccount";
    //注册账户
    public static final String ACCOUNT_REIGSTER="/registerAccount";
    //查询账户代币
    public static final String ACCOUNT_QUERY_COIN="/query/accountCoin";
    //充值 扣除
    public static final String ACCOUNT_UPDATE_COIN="/update/accountCoin";
    //新增商户
    public static final String ACCOUNT_INSERT_ACCOUNTINFO="/insert/accountInfo";
    //新增代理商
    public static final String ACCOUNT_INSERT_AGENT_ACCOUNT="/insert/agentAccount";
    //查看商户详情
    public static final String ACCOUNT_QUERY_ACCOUNTINFO_DETAIL="/query/accountInfoDetail";
    //修改商户资料
    public static final String ACCOUNT_UPDATE_ACCOUNTINFO_DETAIL="/update/accountInfoDetail";
    //修改代理商
    public static final String ACCOUNT_UPDATE_AGENT_DETAIL="/update/agentInfoDetail";
    //用户名是否存在
    public static final String ACCOUNT_USERNAME_EXIST="/usernameExist";
    //查询账户类型
    public static final String ACCOUNT_QUERY_TYPE="/queryAccountType";
    //查询账户企业名称
    public static final String ACCOUNT_QUERY_SIMPLE_COMPANY_NAME="/query/AccountSimpleCompanyName";
    //查询代理商详情
    public static final String ACCOUNT_QUERY_AGENT_DETAIL="/query/agentInfoDetail";

    // *****************************************************************************************************************
    // auth
    public static final String AUTH = "/auth";
    //登录
    public static final String AUTH_LOG_IN = "/login";
    //修改密码
    public static final String ACCOUNT_UPDATE_PASSWORD="/updatePassword";
    //短信验证码
    public static final String AUTH_MSM_CODE = "/loginSmsCode";
    //校验短信验证码
    public static final String AUTH_MSM_CHECK_CODE = "/checkSmsCode";
    //手机号是否存在
    public static final String AUTH_PHONE_EXIST="/accountExist";
    //代理商是否存在
    public static final String AUTH_AGENT_EXIST="/agentExist";
    //商户是否存在
    public static final String AUTH_ACCOUNT_MERCHANT_EXIST="/accountMerchantExist";
    //手动统计总览页数据 测试环境
    public static final String AUTH_RESET_OPERATE_STAT="/startOperateStat";

    // *****************************************************************************************************************
    //商户
    public static final String MERCHANT = "/merchant";
    //查询商户一级类别
    public static final String MERCHANT_TYPE_ONE = "/query/merchantTypeOne";
    //查询商户子类别
    public static final String MERCHANT_TYPE_CHILDREN = "/query/merchantTypeByPid";
    //商户上传文件
    public static final String MERCHANT_UPLOAD_FILE = "/uploadMerchantFile";
    //创建门店
    public static final String MERCHANT_CREATE = "/createMerchant";
    //查询商户列表
    public static final String MERCHANT_QUERY_MERCHANT = "/query/merchantList";
    //设置默认商户
    public static final String MERCHANT_UPDATE_DEFAULT_MERCHANT="/update/defaultMerchant";
    //查看默认商户
    public static final String MERCHANT_QUERY_DEFAULT_MERCHANT="/query/defaultMerchant";
    //营业执照唯一性校验
    public static final String MERCHANT_QUERY_LICENCE_EXIST="/query/existLicenceId";
    //查询门店详情
    public static final String MERCHANT_QUERY_MERCHANT_DETAIL="/query/merchantDetail";
    //查询门店详情-编辑
    public static final String MERCHANT_QUERY_MERCHANT_DETAIL_EDIT="/query/merchantDetailByEdit";
    //修改门店详情
    public static final String MERCHANT_UPDATE_MERCHANT_DETAIL_EDIT="/update/merchantDetailByEdit";
    //商户是否有相同名称的门店
    public static final String MERCHANT_VERIFY_MERCHANT_NAME="/verify/merchantName";
    //设置代理商返点
    public static final String MERCHANT_INSERT_REBATE="/insert/rebate";
    //查看代理商返点
    public static final String MERCHANT_QUERY_REBATE="/query/rebate";
    //创建传单库分组
    public static final String MERCHANT_INSERT_FILE_GROUP="/insert/fileGroup";
    //重命名传单库分组名称
    public static final String MERCHANT_UPDATE_FILE_GROUP="/update/fileGroup";
    //查询传单库分组
    public static final String MERCHANT_QUERY_FILE_GROUP="/query/fileGroup";
    //新增传单库传单
    public static final String MERCHANT_INSERT_FILE_FLYER="/insert/fileFlyer";
    //修改传单
    public static final String MERCHANT_UPDATE_FILE_FLYER="/update/fileFlyer";
    //删除传单
    public static final String MERCHANT_DELETE_FILE_FLYER="/delete/fileFlyer";
    //删除分组
    public static final String MERCHANT_DELETE_FILE_GROUP="/delete/fileGroup";
    //查询传单页
    public static final String MERCHANT_QUERY_FILE_FLYER_PAGE="/query/fileFlyerByPage";

    // *****************************************************************************************************************
    //活动
    public static final String ACTIVITY = "/activity";
    //创建活动
    public static final String ACTIVITY_CREATE_ACTIVITY = "/create/activity";
    //活动草稿投放
    public static final String ACTIVITY_UPDATE_ACTIVITY = "/update/activity";
    //活动列表
    public static final String ACTIVITY_QUERY_ACTIVITY_PAGE = "/query/activityPage";

    //活动广告渠道总数据
    public static final String ACTIVITY_QUERY_CHANNEL = "/query/channel";
    //活动广告渠道每日数据
    public static final String ACTIVITY_QUERY_CHANNEL_DAILY_PAGE = "/query/daily/channelPage";
    //获取活动可添加渠道
    public static final String ACTIVITY_QUERY_CHANNEL_LIST = "/query/activity/channel";
    //活动添加渠道
    public static final String ACTIVITY_CREATE_ACTIVITY_CHANNEL = "/create/activity/channel";
    //活动删除渠道
    public static final String ACTIVITY_DELETE_ACTIVITY_CHANNEL = "/delete/activity/channel";
    //录入每日数据
    public static final String ACTIVITY_CREATE_CHANNEL_DAILY = "/create/channel/dailyData";
    //更新每日数据
    public static final String ACTIVITY_UPDATE_CHANNEL_DAILY = "/update/channel/dailyData";
    //删除每日数据
    public static final String ACTIVITY_DELETE_CHANNEL_DAILY = "/delete/channel/dailyData";
    //渠道管理页查询渠道
    public static final String ACTIVITY_QUERY_CHANNEL_PAGE = "/query/channelPage";
    //渠道管理页新增渠道
    public static final String ACTIVITY_ADD_CHANNEL = "/add/channel";
    //渠道管理页删除渠道
    public static final String ACTIVITY_DELETE_CHANNEL = "/delete/channel";



    //活动详情
    public static final String ACTIVITY_QUERY_ACTIVITY_DETAIL = "/query/activityDetail";
    //查看目标人群数量
    public static final String ACTIVITY_QUERY_ACTTARGERFLOW="/query/actTargerFlow";
    //启动/暂停活动投放
    public static final String ACTIVITY_UPDATE_ACTIVITY_STATUS="/update/activityStatus";
    //广告修改活动状态(广告)
    public static final String ACTIVITY_ADVERTISE_UPDATE_STATUS = "/advertise/updateStatus";
    //活动返单(广告)
    public static final String ACTIVITY_ADVERTISE_RETURN_COIN = "/advertise/activityReturnCoin";
    //审核不通过(广告)
    public static final String ACTIVITY_ADVERTISE_UPDATE_AUDIT_NO = "/advertise/update/acticityAuditNo";
    //保存活动草稿
    public static final String ACTIVITY_CREATE_ACTIVITY_DRAFT = "/create/activityDraft";
    //活动结算
    public static final String ACTIVITY_BALANCE = "/update/activityBalance";
    // *****************************************************************************************************************
    //订单
    public static final String ORDER = "/order";
    //商户的充值管理消费和充值记录
    public static final String ORDER_QUERY_COINLOG_MERCHANT = "/query/coinLogPageByMerchant";
    //运营的充值管理
    public static final String ORDER_QUERY_COINLOG_OPERATE = "/query/coinLogPageByOperate";
    // *****************************************************************************************************************
    //审核
    public static final String VERIFY = "/verify";
    //查询商户审核列表
    public static final String VERIFY_QUERY_ACCOUNT_BYSTATUS = "/query/accountByStatus";
    //查询商户详情
    public static final String VERIFY_QUERY_ACCOUNTINFO_DETAIL="/query/accountInfoDetail";
    //查询商户详情审核--by编辑
    public static final String VERIFY_QUERY_ACCOUNTINFO_DETAIL_EDIT="/query/accountInfoDetailByEdit";
    //审核商户
    public static final String VERIFY_MERCHANT_ACCOUNT="/update/accountStatus";
    //审核代理商
    public static final String VERIFY_AGENT_ACCOUNT="/update/agentAccountStatus";
    //查询门店审核列表
    public static final String VERIFY_QUERY_MERCHANT_BYSTATUS = "/query/merchantListByStatus";
    //查询代理商列表
    public static final String VERIFY_QUERY_AGENT_BYSTATUS = "/query/agentListByStatus";
    //审核门店
    public static final String VERIFY_MERCHANT_MERCHANT="/update/merchantStatus";
    //资质校验
    public static final String VERIFY_UPDATE_CHECK_STATUS="/update/checkStatus";
   // *****************************************************************************************************************
    // 代理商
   public static final String AGENT = "/agent";
    // *****************************************************************************************************************
    public static final String LOG = "/log";
    public static final String LOG_QUERY_OPERATE_LOG = "/query/operateLog";
    public static final String LOG_QUERY_RECHARGE_LOG = "/query/rechargeLog";
}
