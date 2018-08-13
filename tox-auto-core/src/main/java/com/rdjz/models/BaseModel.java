package com.rdjz.models;

import java.io.Serializable;

/**
 *
 * @author None
 * @since 2015-6-11
 * @version 1.0.0
 *
 */
public interface BaseModel extends Serializable {
    Integer Product_onlineStatus_online = 1;
    Integer Product_onlineStatus_offline = 0;
    Integer Product_searchStatus_search = 1;
    Integer Product_searchStatus_no_search  = 0;
    Integer Product_storeStrategy_paied = 0;
    Integer Product_storeStrategy_buy = 1;
    Integer Product_storeStrategy_shipping = 3;
    Integer ProductPicture_mainPic_main = 1;
    Integer ArticlePicture_mainPic_notMain = 0;
    Integer ProductPicture_mainPic_notMain = 0;
    Integer CategoryProperty_propertyType_sale = 1;
    Integer CategoryProperty_propertyType_key = 2;
    Integer User_active_yes = 1;
    Integer User_active_no = 0;
    Integer User_special_yes = 1;
    Integer User_special_no = 0;
    Integer User_emailBound_yes = 1;
    Integer User_emailBound_no = 0;
    Integer User_phoneBound_yes = 1;
    Integer User_phoneBound_no = 0;
    Integer CartItem_selected_yes = 1;
    Integer CartItem_selected_no = 0;
    Integer UserAddress_defaultAddress_yes = 1;
    Integer UserAddress_defaultAddress_no = 0;
    Integer Status_enable = 0;
    Integer Status_disable = 1;

    Integer OrderItem_uncomment = 0;
    Integer OrderItem_commented = 1;
    Integer CanMasterSubShow = 0;
    Integer NotCanMasterSubShow = 1;
    String Share_userKey = "userKey";
    String No = "N";
    String Yes = "Y";

    Integer getId();

    void setId(Integer id);
}
