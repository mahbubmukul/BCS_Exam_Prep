package com.exam_prep.bcs.util.constant

import com.exam_prep.bcs.BuildConfig

object ApiConstants {

    const val AUTHORIZATION_KEY = "Authorization";
    const val IPAY_BASE_URL = BuildConfig.BASE_URL_IPAY

    const val PRIYO_PAYMENT_OPTION_ID = "paymentOptionId"
    const val PRIYO_PAYMENT_ACCOUNT_ID = "paymentAccountId"

    const val PRIYO_AUTH_LOGIN_ENDPOINT = "login/"
    const val PRIYO_AUTH_LOGOUT_ENDPOINT = "logout/"
    const val PRIYO_AUTH_EMAIL_SIGNUP_ENDPOINT = "register/"
    const val PRIYO_AUTH_GET_USER_ENDPOINT = "user-profile/"
    const val PRIYO_AUTH_UPDATE_USER_ENDPOINT = "update-user-profile/"

    const val PRIYO_AUTH_GET_JOB_PROFIE_ENDPOINT = "job-profile/aggregated/"
    const val PRIYO_AUTH_SEARCH_BUSINESS_ENDPOINT = "businesses/"

    const val PRIYO_AUTH_UPDATE_MOBILE_ENDPOINT = "update-email-phone/"

    const val PRIYO_AUTH_OTP_RESEND_ENDPOINT = "otp/resend/"
    const val PRIYO_AUTH_OTP_VERIFY_ENDPOINT = "otp/verify/"
    const val PRIYO_AUTH_EMAIL_VERIFY_ENDPOINT = "/email/verify/"
    const val PRIYO_AUTH_RESEND_EMAIL_VERIFICATION_EMAIL_ENDPOINT = "email/verify-resend/"
    const val PRIYO_AUTH_RESET_PASSWORD_ENDPOINT = "forget-password/"
    const val PRIYO_AUTH_RESET_PASSWORD_VIA_EMAIL_ENDPOINT = "reset-password/"

    const val PRIYO_AUTH_SEARCH_USER_VIA_MOBILE_ENDPOINT = "get-profile-by-mobile/"
    const val PRIYO_AUTH_GET_USER_BY_UUID_ENDPOINT = "user-profile-by-uid/"

    const val PRIYO_AUTH_GET_OTHER_USER_BY_UUID_ENDPOINT = "other-user-profile-by-uid/"

    const val PRIYO_AUTH_RESET_PASSWORD_VIA_MOBILE_ENDPOINT = "reset-password-by-mobile/"
    const val PRIYO_AUTH_INTEREST_LIST_ENDPOINT = "interests/"
    const val PRIYO_AUTH_UPDATE_PHOTO = "file-upload/"

    const val PRIYO_GO_AUTH_ADD_ADDRESS_ENDPOINT = "address/"
    const val PRIYO_GO_AUTH_UPDATE_ADDRESS_ENDPOINT = "address/{pk}/"

    const val PRIYO_AUTH_FACEBOOK_LOGIN_ENDPOINT = "social/login/"


    const val PRIYO_PAYMENT_ALL_PAYMENT_TYPE_ENDPOINT = "point/payment-info/"
    const val PRIYO_PAYMENT_PAYMENT_TYPE_ENDPOINT =
        "$PRIYO_PAYMENT_ALL_PAYMENT_TYPE_ENDPOINT{$PRIYO_PAYMENT_OPTION_ID}/"
    const val PRIYO_PAYMENT_ALL_PAYMENT_ACCOUNT_ENDPOINT = "point/payment-info-account/"
    const val PRIYO_PAYMENT_ACCOUNT_ENDPOINT = "$PRIYO_PAYMENT_ALL_PAYMENT_ACCOUNT_ENDPOINT{$PRIYO_PAYMENT_ACCOUNT_ID}/"
    const val PRIYO_PAYMENT_POINT_IPAY_ACCOUNT_DETAILS_ENDPOINT = "point/get-ipay-profile/"


    const val PRIYO_FEATURED_CONTENT_ENDPOINT = "featured-content/"
    const val PRIYO_ANALYTICS_UPLOAD_ENDPOINT = "collector/event/user_activity/"
    const val PRIYO_USER_ACTIVITY_UPLOAD_ENDPOINT = "collector/v2/event/"

    const val PRIYO_HOROSCOPE_ENDPOINT = "horoscopes/"


    const val PRIYO_REFERAL_ACTIVITY_UPLOAD_ENDPOINT = "/collector/share-referral/"

    const val PRIYO_NEW_ANALYTICS_UPLOAD_ENDPOINT = "analytics/"
    const val PRIYO_NEW_ANALYTICS_TRENDING_BUSINESS_ENDPOINT = "business/business-in-news/"
    const val PRIYO_NEW_ANALYTICS_TRENDING_TOPIC_ENDPOINT = "${PRIYO_NEW_ANALYTICS_UPLOAD_ENDPOINT}topic/"
    const val PRIYO_NEW_ANALYTICS_TRENDING_PEOPLE_ENDPOINT = "people/people-in-news/"

    const val BIDDING_AUCTION_ITEM_LIST_ENDPOINT = "bidding/auction/"
    const val BIDDING_AUCTION_BID_ENDPOINT = "bidding/event/"
    const val BIDDING_PRODUCT_TOP_BID_ENDPOINT = "bidding/topbid/"
    const val PRIYO_GO_BIDDING_AUCTION_LEADERBOARD_ENDPOINT = "bidding/leaderboard/"

    const val PRIYO_GO_POINT_BALANCE_ENDPOINT = "point/balance/"
    const val PRIYO_GO_POINT_PURCHASE_STATUS_UPDATE_ENDPOINT = "point/payment/confirm/{checkoutId}/{statusType}/"
    const val PRIYO_GO_POINT_PURCHASE_ENDPOINT = "point/purchase-with-ipay/"
    const val PRIYO_GO_POINT_REDEEM_ENDPOINT = "point/redeem-coupon/"
    const val PRIYO_GO_POINT_PURCHASE_CHECKOUT_ENDPOINT = "point/purchase-with-checkout/"
    const val PRIYO_GO_POINT_SHARE_ENDPOINT = "point/transfer/"
    const val PRIYO_GO_POINT_IPAY_WITHDRAW_ENDPOINT = "point/withdraw/"

    const val PRIYO_GO_DEALS_ITEM_LIST_ENDPOINT = "sales/products/"
    const val PRIYO_GO_MY_OFFERS_ITEM_LIST_ENDPOINT = "sales/offers/"
    const val PRIYO_GO_MY_OFFERS_ITEM_LIST_BY_USER_ENDPOINT = "sales/offers/user/"
    const val PRIYO_GO_MY_OFFERS_ITEM_LIST_NEARBY_ENDPOINT = "sales/offers/nearby/"
    const val PRIYO_GO_MY_OFFERS_DETAILS_ENDPOINT = "sales/offers/detail/"
    const val PRIYO_GO_MY_OFFERS_CATEGORY_LIST_ENDPOINT = "catalog/categories/"
    const val PRIYO_GO_MY_OFFERS_CREATE_ENDPOINT = "sales/offers/create/"
    const val PRIYO_GO_MY_OFFERS_UPDATE_ENDPOINT = "sales/offers/update/"
    const val PRIYO_GO_MY_OFFERS_DELETE_ENDPOINT = "sales/offers/delete/"

    const val PRIYO_GO_MY_SINGLE_OFFERS_LIST_ENDPOINT = "$PRIYO_GO_MY_OFFERS_ITEM_LIST_ENDPOINT{offerId}/"
    const val PRIYO_GO_DELETE_OFFER_ENDPOINT = "$PRIYO_GO_MY_OFFERS_DELETE_ENDPOINT{offerId}/"

    const val PRIYO_GO_DEALS_BUY_NOW_ENDPOINT = PRIYO_GO_DEALS_ITEM_LIST_ENDPOINT + "buy-now/"

    const val PRIYO_GO_NOTIFICATION_ENDPOINT = "notification/sent-to-you/"
    const val PRIYO_GO_NOTIFICATION_ENDPOINT_V2 = "notification/sent-to-you/v2/"
    const val PRIYO_GO_NOTIFICATION_UNSEEN_COUNT_ENDPOINT = "notification/unread-count/"
    const val PRIYO_GO_NOTIFICATION_SEEN_RESPONSE_ENDPOINT = "notification/seen/"
    const val PRIYO_GO_PAGINATED_API = "{paginatedApi}"
    const val PRIYO_GO_NOTIFICATION_DELETE_LOOP_ENDPOINT = "notification/remove/loop/"

    const val PRIYO_GO_LOCATION_ENDPOINT = "location/"
    const val PRIYO_GO_LOCATION_NEARBY_ENDPOINT = "${PRIYO_GO_LOCATION_ENDPOINT}nearby/"
    const val PRIYO_GO_NEWS_ENDPOINT = "feeds/"
    const val PRIYO_GO_NEWS_BY_MODEL_ENDPOINT = "feeds-by-model/"

    const val PRIYO_GO_NEWS_BY_MODEL_ENDPOINT_V2 = "feeds-by-model/v2/"
    const val PRIYO_GO_ARTICLES_ENDPOINT = "feeds/{id}/"
    const val PRIYO_GO_LOCATION_NEWS_ENDPOINT = "feeds/by-geolocation/"
    const val PRIYO_GO_NEWS_RELATED_NEWS_ENDPOINT = "e/{articleID}/more-and-related-feeds/" //"articles/{articleSlug}/related-news/"
    const val PRIYO_GO_TRENDING_NEWS_ENDPOINT = "${PRIYO_GO_NEWS_ENDPOINT}trending/"
    const val PRIYO_GO_NEARBY_NEWS_ENDPOINT = "${PRIYO_GO_NEWS_ENDPOINT}nearby/"

    const val PRIYO_GO_NEWS_BY_QUEUE_ENDPOINT = "feeds-by-queue/"
    const val PRIYO_GO_TOP_NEWS_ENDPOINT = "${PRIYO_GO_NEWS_ENDPOINT}personal/"
    const val PRIYO_GO_RECOMENDED_NEWS_ENDPOINT = "${PRIYO_GO_NEWS_ENDPOINT}recommended/v2/"

    const val PRIYO_GO_NEWS_BY_NEWSPAPER_ENDPOINT = "${PRIYO_GO_NEWS_ENDPOINT}personal/"
//    const val PRIYO_GO_TOP_NEWS_ENDPOINT = "${PRIYO_GO_NEWS_ENDPOINT}top-priority/"
    const val PRIYO_GO_TOP2_NEWS_ENDPOINT = "feeds-by-queue/top-story/"

    const val PRIYO_GO_JOB_LIST_ENDPOINT = "jobs/"
    const val PRIYO_GO_JOB_BOOKMARK_ENDPOINT = "jobs/bookmark-job/"
    const val PRIYO_GO_JOB_INDUSTRIES_ENDPOINT = "job-industries/"

    const val PRIYO_GO_BUSINESS_ENDPOINT = "business/{slug}"
    const val PRIYO_GO_NEARBY_BUSINESS_ENDPOINT = "${PRIYO_GO_BUSINESS_ENDPOINT}nearby/"

    const val PRIYO_GO_ORDER_ENDPOINT = "order/"
    const val PRIYO_GO_ORDER_LIST_ENDPOINT = "${PRIYO_GO_ORDER_ENDPOINT}orders/"

    const val PRIYO_GO_VERSION_ENDPOINT = "metadata/app-version/v2/"

    const val PRIYO_GO_PEOPLE_ENDPOINT = "people/{slug}"
    const val PRIYO_GO_PEOPLE_MORE_NEWS_ENDPOINT = "people/{slug}/more-news/"

    const val PRIYO_GO_NEW_TOPUP_ENDPOINT = "topup/"

    const val PRIYO_GO_SHIPPING_ADDRESS_ENDPOINT = "order/shipping/address/"

    const val PRIYO_GO_CONTACT_ENDPOINT = "contacts/"
    const val PRIYO_GO_CONTACT_NEW_PEOPLE_ENDPOINT = "latest/user/"

    const val PRIYO_GO_AUTHOR_SIGNUP_ENDPOINT = "create/api/"
    const val PRIYO_GO_AUTHOR_GET_PROFILE_ENDPOINT = "api/"
    const val PRIYO_GO_AUTHOR_UPDATE_PROFILE_ENDPOINT = "update/api/"
    const val PRIYO_GO_AUTHOR_PUBLISHED_ARTICLE_LIST_ENDPOINT = "/api/articles/"
    const val PRIYO_GO_AUTHOR_PUBLISHED_ARTICLE_DETAILS_ENDPOINT = "/api/articles/{id}/"
    const val PRIYO_GO_AUTHOR_UNPUBLISHED_ARTICLE_LIST_ENDPOINT = "/api/post/"
    const val PRIYO_GO_AUTHOR_CREATE_ARTICLE_ENDPOINT = "/api/post/create/"

    const val PRIYO_GO_AUTHOR_UNPUBLISHED_ARTICLE_DETAILS_ENDPOINT = "/api/post/{id}/"

    const val PRIYO_GO_TRANSACTION_HISTORY_ENDPOINT = "payment/transactions/"

    const val PRIYO_LOOP_GET_ALL_LIST_ENDPOINT = "connection/"
    const val PRIYO_LOOP_GET_REQUEST_LIST_ENDPOINT = "request/"
    const val PRIYO_LOOP_SEND_REQUEST_ENDPOINT = "sent-request/"
    const val PRIYO_LOOP_REQUEST_ACTION_ENDPOINT = "request/settle/"
    const val PRIYO_LOOP_UNLOOP_ENDPOINT = "disconnect/"
    const val PRIYO_LOOP_SEARCH_ENDPOINT = "search/"

    const val PRIYO_QUIZ_GET_QUIZ_DETAILS_ENDPOINT = "public/quiz/{quiz_id}/details/"

    const val PRIYO_QUIZ_GET_LIST_DAILY_QUIZ_ENDPOINT = "dailyquiz/"
    const val PRIYO_QUIZ_GET_QUIZ_PROFILE_ENDPOINT = "quiz/{quiz_id}/profile/"
    const val PRIYO_QUIZ_START_ENDPOINT = "start/"
    const val PRIYO_QUIZ_ANSWER_ENDPOINT = "answer/"
    const val PRIYO_QUIZ_RESULT_ENDPOINT = "winners/"


    const val PRIYO_QUIZ_GET_CATEGORY_LIST_ENDPOINT = "quiz-categories/running/"
    const val PRIYO_QUIZ_GET_PAST_CATEGORY_LIST_ENDPOINT = "quiz-categories/previous/"

    const val PRIYO_QUIZ_GET_CATEGORIZED_QUIZ_ENDPOINT = "quiz-categories/{cat_id}/running-quizzes"
    const val PRIYO_QUIZ_GET_PAST_QUIZ_ENDPOINT = "quiz-categories/{cat_id}/previous-quizzes"
    const val PRIYO_QUIZ_GET_QUIZ_DETAILS_WITH_WINNERS_ENDPOINT = "quiz/{quiz_id}/with-winners"

    const val PRIYO_GO_BASE_URL = BuildConfig.BASE_URL_PRIYOGO
    const val PRIYO_ANALYTICS_BASE_URL = BuildConfig.BASE_URL_PRIYO_ANALYTICS

    const val PRIYO_REFERAL_BASE_URL = BuildConfig.BASE_URL_PRIYO_REFERAL
    const val PRIYO_BASE_URL = BuildConfig.BASE_URL_PRIYO
    const val PRIYO_OLD_BASE_URL = BuildConfig.BASE_URL_PRIYOOLD
    const val PRIYO_GO_BASE_AUTHOR_URL = BuildConfig.BASE_URL_PRIYOGO_AUTHOR
    const val MUJIBMAP_BASE_URL = BuildConfig.BASE_URL_MUJIBMAP
    const val PRIYO_AUTH_BASE_URL = BuildConfig.BASE_URL_PRIYO_AUTH

    const val PRIYO_AUTH_BASE_URL_V2 = BuildConfig.BASE_URL_PRIYO_AUTH_V2
    const val PRIYO_LOOP_BASE_URL = BuildConfig.BASE_URL_PRIYO_LOOP
    const val PRIYO_QUIZ_BASE_URL = BuildConfig.BASE_URL_PRIYO_QUIZ

    const val BIDDING_API_KEY = BuildConfig.API_KEY_BIDDING

    const val PRIYO_GO_API_KEY_HEADER = "key"
    const val USER_AGENT_HEADER = "User-Agent"
    const val ACCEPT_HEADER = "Accept"
    const val CONTENT_TYPE_HEADER = "Content-Type"

    const val USER_AGENT_MOBILE_ANDROID = "mobile-android"
    const val ACCEPT_HEADER_JSON_UTF_8 = "application/json;charset=UTF-8"
    const val CONTENT_TYPE_JSON_UTF_8 = "application/json;charset=UTF-8"
    const val TOKEN = "token"

    const val MUJIB_MAP_CATEGORY_ENDPOINT = "categories/"
    const val PROMO_ADS_ENDPOINT = "promo-ads/"
}