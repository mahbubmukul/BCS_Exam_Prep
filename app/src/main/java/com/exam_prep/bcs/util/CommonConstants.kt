package com.exam_prep.bcs.util

import com.google.gson.Gson
import com.google.gson.GsonBuilder

/**
 * @author RaggedyCoder
 * @since 2018
 */
object CommonConstants {

    const val SITE_NAME_FACEBOOK = "FACEBOOK"

    const val INVALID_TIMESTAMP = -1L
    const val INVALID_ACCESS_TOKEN = ""
    const val INVALID_FIRE_BASE_TOKEN = ""

    val DEFAULT_GSON = GsonBuilder().serializeNulls().create()!!
    val HIDE_NON_EXPOSED_GSON = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()!!
    val DEFAULT_NON_NULL_GSON = Gson()
    const val TERMS_AND_CONDITION_URL = "https://www.priyo.com/terms-and-conditions/"
    const val PRIVACY_URL = "https://www.priyo.com/privacy-policy"
    const val FAQ_URL = "http://go.priyo.com/faq/"

    const val DEFAULT_ADDRESS_TYPE = "present"
    const val DEFAULT_SHIPPING_ADDRESS_NUMBER = "Primary"
    const val ADDRESS_TYPE_PRESENT = "present"
    const val ADDRESS_TYPE_PERMANENT = "permanent"
    const val ADDRESS_TYPE_SHIPPING = "shipping"
    const val COUNTRY_CODE_BD = "BD"

    const val PLATFORM_PRIYOGO = "PRIYOGO"
    const val DEVICE_PLATFORM = "android"

    const val LOGGED_IN_MEDIA_EMAIL = "email"

    const val UPLOAD_NEW_PROFILE_PICTURE = "Select new profile picture"
    const val CAPTURE_NEW_PROFILE_PICTURE = "Capture new profile picture"

    const val EVENT_CATEGORY_AUCTION = "auction"
    const val EVENT_CATEGORY_PEOPLE = "people"
    const val EVENT_CATEGORY_POINT = "point"
    const val EVENT_CATEGORY_SALES = "sales"
    const val EVENT_CATEGORY_NEWS = "news"
    const val EVENT_CATEGORY_BUSINESS = "business"
    const val EVENT_CATEGORY_OTHER = "other"

    const val EVENT_CATEGORY_SALES_SUB_CATEGORY_DEAL = "deal"
    const val EVENT_CATEGORY_SALES_SUB_CATEGORY_OFFER = "offer"
    const val EVENT_CATEGORY_POINT_SUB_CATEGORY_BUY = "buy"
    const val EVENT_CATEGORY_POINT_SUB_CATEGORY_TRANSFER = "transfer"
    const val EVENT_CATEGORY_POINT_SUB_CATEGORY_TOPUP = "topup"
    const val EVENT_CATEGORY_POINT_SUB_CATEGORY_WITHDRAW = "withdraw"

    const val REFERRER_ANDROID = "android"
    const val DEFAULT_WEIGHT = 1

    const val SERVICE_NAME_BID = "bid"

    const val IMAGE_FOLDER = "PriyoImages"

    const val DEEP_LINK_ACTION = "DEEP_LINK_ACTION"
    const val SERVICE_TYPE_ACTION = "SERVICE_TYPE_ACTION"
}
