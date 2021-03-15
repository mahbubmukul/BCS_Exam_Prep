package com.exam_prep.bcs.util

import androidx.core.content.edit
import com.exam_prep.bcs.BCSApplication
import com.exam_prep.bcs.util.constant.SharedPreferenceConstants

object SharedPreferenceUtil {

    private val preferences = BCSApplication.preferences
    private val TAG = SharedPreferenceUtil::class.java

    fun clearAllPreferences() = preferences.edit {
        clear()
    }

    fun isFirstTimeLaunch() = preferences.getBoolean(SharedPreferenceConstants.PRIYO_FIRST_LAUNCH_KEY, true)

    fun setAppLaunched() = preferences.edit {
        putBoolean(SharedPreferenceConstants.PRIYO_FIRST_LAUNCH_KEY, false)
    }

    fun isLoggedIn() = preferences.getBoolean(SharedPreferenceConstants.PRIYO_LOGGED_IN_KEY, false)

    fun setLoggedIn(b: Boolean) = preferences.edit {
        putBoolean(SharedPreferenceConstants.PRIYO_LOGGED_IN_KEY, b)
    }

    fun getPriyoAccessToken() =
        preferences.getString(
            SharedPreferenceConstants.PRIYO_ACCESS_TOKEN_KEY,
            CommonConstants.INVALID_ACCESS_TOKEN
        )

    fun getPriyoAuthToken() =
        preferences.getString(
            SharedPreferenceConstants.PRIYO_AUTH_TOKEN_KEY,
            CommonConstants.INVALID_ACCESS_TOKEN
        )

    fun isPriyoTokenAvailable() = preferences.contains(SharedPreferenceConstants.PRIYO_ACCESS_TOKEN_KEY)

    fun setSessionId(id: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.SESSION_ID_KEY, id)
        }

    fun getSessionId() = preferences.getString(SharedPreferenceConstants.SESSION_ID_KEY, "") ?: ""


    /*





    fun isLocationSend() = preferences.contains(SharedPreferenceConstants.IS_LOCATION_SAVED)

    fun setIsLocationSend(b: Boolean) = preferences.edit {
        putBoolean(SharedPreferenceConstants.IS_LOCATION_SAVED, b)
    }

    private fun setUUID(uuid: String?) = preferences.edit {
        putString(SharedPreferenceConstants.UUID_KEY, uuid)
    }

    fun getUUID() = preferences.getString(SharedPreferenceConstants.UUID_KEY, "")

    private fun setUserId(userId: Int) = preferences.edit {
        putInt(SharedPreferenceConstants.USER_ID_KEY, userId)
    }

    fun getUserId(): Int? {
        val id = preferences.getInt(SharedPreferenceConstants.USER_ID_KEY, -1)
        return if (id == -1) {
            null
        } else {
            id
        }
    }

    fun setDeviceId(userId: Long) = preferences.edit {
        putLong(SharedPreferenceConstants.DEVICE_ID_KEY, userId)
    }

    fun getDeviceId(): Long? {
        return preferences.getLong(SharedPreferenceConstants.DEVICE_ID_KEY, -1)
    }

    fun setLatitude(latitude: Double) = preferences.edit {
        putString(SharedPreferenceConstants.LATITUDE_KEY, latitude.toString())
    }

    fun getLatitude(): String? {
        return preferences.getString(SharedPreferenceConstants.LATITUDE_KEY, null)
    }

    fun setLongitude(longitude: Double) = preferences.edit {
        putString(SharedPreferenceConstants.LONGITUDE_KEY, longitude.toString())
    }

    fun getLongitude(): String? {
        return preferences.getString(SharedPreferenceConstants.LONGITUDE_KEY, null)
    }

    fun setUserEmailVerified(isVerified: Boolean) =
        preferences.edit {
            putBoolean(SharedPreferenceConstants.PRIYO_USER_EMAIL_IS_VERIFIED_KEY, isVerified)
        }

    fun isUserEmailVerified() =
        preferences.getBoolean(SharedPreferenceConstants.PRIYO_USER_EMAIL_IS_VERIFIED_KEY, false)

    fun setUserEmail(email: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_EMAIL_KEY, email)
        }

    fun getUserEmail() = preferences.getString(SharedPreferenceConstants.USER_EMAIL_KEY, "") ?: ""

    fun setUserMobileVerified(isVerified: Boolean) =
        preferences.edit {
            putBoolean(SharedPreferenceConstants.PRIYO_USER_MOBILE_IS_VERIFIED_KEY, isVerified)
        }

    fun isUserMobileNumberVerified() =
        preferences.getBoolean(SharedPreferenceConstants.PRIYO_USER_MOBILE_IS_VERIFIED_KEY, false)

    fun getUserMobileNumber() = preferences.getString(SharedPreferenceConstants.USER_MOBILE_NUMBER_KEY, "")
        ?: ""

    fun setUserMobile(mobileNumber: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_MOBILE_NUMBER_KEY, mobileNumber)
        }

    fun getUserName() = preferences.getString(SharedPreferenceConstants.USER_NAME_KEY, "")
        ?: ""

    fun setUserName(userName: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_NAME_KEY, userName)
        }

    fun getFirstName() = preferences.getString(SharedPreferenceConstants.USER_FIRST_NAME_KEY, "")
        ?: ""

    fun setFirstName(firstName: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_FIRST_NAME_KEY, firstName)
        }

    fun getLastName() = preferences.getString(SharedPreferenceConstants.USER_LAST_NAME_KEY, "")
        ?: ""

    fun setLastName(lastName: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_LAST_NAME_KEY, lastName)
        }

    fun getFatherName() = preferences.getString(SharedPreferenceConstants.USER_FATHER_NAME_KEY, "")
        ?: ""

    fun setFathertName(lastName: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_FATHER_NAME_KEY, lastName)
        }

    fun getMotherName() = preferences.getString(SharedPreferenceConstants.USER_MOTHER_NAME_KEY, "")
        ?: ""

    fun setMotherName(lastName: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_MOTHER_NAME_KEY, lastName)
        }

    fun getGender() = preferences.getString(SharedPreferenceConstants.USER_GENDER_KEY, "")
        ?: ""

    fun setGender(gender: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_GENDER_KEY, gender)
        }

    fun getReligion() = preferences.getString(SharedPreferenceConstants.USER_GENDER_KEY, "")
        ?: ""

    fun setReligion(gender: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_GENDER_KEY, gender)
        }

    fun getMaritialStatus() = preferences.getString(SharedPreferenceConstants.USER_GENDER_KEY, "")
        ?: ""

    fun setMaritialStatus(gender: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_GENDER_KEY, gender)
        }

    fun getNatinality() = preferences.getString(SharedPreferenceConstants.USER_GENDER_KEY, "")
        ?: ""

    fun setNatinality(gender: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_GENDER_KEY, gender)
        }

    fun getNID() = preferences.getString(SharedPreferenceConstants.USER_GENDER_KEY, "")
        ?: ""

    fun setNID(gender: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_GENDER_KEY, gender)
        }

    fun getUserDOB() = preferences.getString(SharedPreferenceConstants.USER_DOB_KEY, "")
        ?: ""

    fun setUserDOB(dateOfBirth: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_DOB_KEY, dateOfBirth)
        }

    fun getUserProfession() = preferences.getString(SharedPreferenceConstants.USER_PROFESSION_KEY, "")
        ?: ""

    fun setUserProfession(userProfession: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_PROFESSION_KEY, userProfession)
        }

    fun getUserBioInfo() = preferences.getString(SharedPreferenceConstants.USER_BIO_INFO_KEY, "")
        ?: ""

    fun setUserBioInfo(userBioInfo: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_BIO_INFO_KEY, userBioInfo)
        }

    fun getUserOrganization() = preferences.getString(SharedPreferenceConstants.USER_ORGANIZATION_KEY, "")
        ?: ""

    fun setUserOrganization(userOrganization: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_ORGANIZATION_KEY, userOrganization)
        }

    fun getProfilePictureUrl() = preferences.getString(SharedPreferenceConstants.USER_PROFILE_PICTURE_KEY, "")
        ?: ""

    fun setProfilePictureUrl(url: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_PROFILE_PICTURE_KEY, url)
        }

    fun getUserAddressList(): MutableList<Address> = CommonConstants.DEFAULT_GSON.fromJson(
        preferences.getString(
            SharedPreferenceConstants.USER_ADDRESS_LIST_KEY,
            "[]"
        )
            ?: "[]",
        object : TypeToken<MutableList<Address>>() {}.type
    )

    fun setUserAddressList(addressList: MutableList<Address>) =
        preferences.edit {
            putString(SharedPreferenceConstants.USER_ADDRESS_LIST_KEY, CommonConstants.DEFAULT_GSON.toJson(addressList))
        }

    fun getUserInterestList(): MutableList<Interest> = CommonConstants.DEFAULT_GSON.fromJson(
        preferences.getString(
            SharedPreferenceConstants.USER_INTEREST_LIST_KEY,
            "[]"
        )
            ?: "[]",
        object : TypeToken<MutableList<Interest>>() {}.type
    )

    fun setUserInterestList(addressList: MutableList<Interest>) =
        preferences.edit {
            putString(
                SharedPreferenceConstants.USER_INTEREST_LIST_KEY,
                CommonConstants.DEFAULT_GSON.toJson(addressList)
            )
        }

    fun setAccessToken(token: String) {
        preferences.edit {
            // Saving User Token
            putString(SharedPreferenceConstants.PRIYO_ACCESS_TOKEN_KEY, token)
        }
    }

    fun setAuthorizationToken(token: String) {
        preferences.edit {
            // Saving User Token
            putString(SharedPreferenceConstants.PRIYO_AUTH_TOKEN_KEY, "Token "+ token)
        }
    }

    fun setLoginReasponse(loginResponse: PriyoLoginResponse) {
        setTokens(loginResponse.token!!)
        setUserInfo(loginResponse.user_data!!)
    }

    fun setTokens(token: String) {
        setAccessToken(token)
        setAuthorizationToken(token)
    }

//    fun setToken(token: String) {
//        val tokenPayLoad =
//            try {
//                CommonConstants.DEFAULT_GSON.fromJson(
//                    String(Base64.decode(token.split(".")[1], Base64.URL_SAFE)),
//                    TokenPayLoad::class.java
//                )
//            } catch (ex: Exception) {
//                PriyoLog.d(LoginViewModel.TAG, "${ex.message}")
//                TokenPayLoad()
//            }
//
//        // Saving Token Info
//        setLongTimeToken(tokenPayLoad.isLongToken)
//        preferences.edit {
//            // Saving User Token
//            putString(SharedPreferenceConstants.PRIYO_ACCESS_TOKEN_KEY, token)
//        }
//        //Saving User information from token payload
//        setFirstName(tokenPayLoad.firstName ?: "")
//        setLastName(tokenPayLoad.lastName ?: "")
//        setProfilePictureUrl(tokenPayLoad.image ?: "")
//        setPriyoTokenExpiryTime(tokenPayLoad.tokenExpireTime)
//        setUUID(tokenPayLoad.uuid)
//        setUserId(tokenPayLoad.userId)
//        setZodiac(tokenPayLoad.zodiac ?: "")
//
//        // Saving Mobile Info
//        setUserMobileVerified(tokenPayLoad.isMobileVerified)
//        if (!tokenPayLoad.mobile.isNullOrBlank())
//            setUserMobile(tokenPayLoad.mobile!!)
//
//        // Saving Email Info
//        setUserEmailVerified(tokenPayLoad.isEmailVerified)
//        if (!tokenPayLoad.email.isNullOrBlank())
//            setUserEmail(tokenPayLoad.email!!)
//    }

    fun getUserInfo() = PriyoAuthProfile(
        getUserId() ?: -1,
        getUserName(),
        getUUID(),
        getUserEmail(),
        getUserMobileNumber(),
        PriyoProfile(
            getZodiac(),
            getFirstName()+" "+ getLastName(),
            getFatherName(),
            getMotherName(),
            getProfilePictureUrl(),
            getGender(),
            getUserDOB(),
            getReligion(),
            getMaritialStatus(),
            getNID(),
            getNatinality(),
            getUserInterestList()
        ),
        null,
        getUserAddressList(),
        isUserMobileNumberVerified(),
        isUserEmailVerified()
    )

    fun setUserInfo(priyoAuthProfile: PriyoAuthProfile) {
        with(priyoAuthProfile) {
            setUserId(id)
            setUUID(uuid)
            setUserName(userName ?: "")
            setFirstName(profile?.name ?: "")
            setFathertName(profile?.father_name ?: "")
            setMotherName(profile?.mother_name ?: "")
            setProfilePictureUrl(profile?.image ?: "")
            setGender(profile?.gender ?: "")
            setUserEmail(email ?: "")
            setUserDOB(profile?.dob ?: "")
            setUserMobile(mobileNumber ?: "")
            setUserEmailVerified(isEmailVerified ?: false)
            setUserMobileVerified(isMobileVerified ?: false)
            setUserAddressList(addresses ?: mutableListOf())
            setUserInterestList(profile?.interestList ?: mutableListOf())
            setZodiac(profile?.zodiac ?: "")
            setReligion(profile?.religion ?: "")
            setMaritialStatus(profile?.marital_status ?: "")
            setNID(profile?.nid ?: "")
            setNatinality(profile?.nationality ?: "")
            setUserOrganization(profile?.organization?: "")
            return@with this
        }
    }

    fun setJobProfile(jobProfile: JobProfile) = preferences.edit {
        putString(
            SharedPreferenceConstants.JOB_PROFILE_CACHE_KEY,
            CommonConstants.DEFAULT_GSON.toJson(jobProfile)
        )
    }

    fun getJobProfile() = CommonConstants.DEFAULT_GSON.fromJson(
        preferences.getString(SharedPreferenceConstants.JOB_PROFILE_CACHE_KEY, "{}"),
        JobProfile::class.java
    )


    fun setAppLanguage(deviceLanguage: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.DEVICE_LANGUAGE_KEY, deviceLanguage)
        }

    fun getAppLanguage() =
        preferences.getString(SharedPreferenceConstants.DEVICE_LANGUAGE_KEY, "bn") ?: "bn"

    fun setZodiac(zodiac: String) =
        preferences.edit {
            putString(SharedPreferenceConstants.ZODIAC_KEY, zodiac)
        }

    fun getZodiac() =
        preferences.getString(SharedPreferenceConstants.ZODIAC_KEY, "") ?: ""

    fun getAnalyticsDataList(): MutableList<AnalyticsData> =
        CommonConstants.DEFAULT_GSON.fromJson(
            preferences.getString(
                SharedPreferenceConstants.ANALYTICS_DATA_LIST_KEY,
                "[]"
            ), object : TypeToken<MutableList<AnalyticsData>>() {
            }.type
        )

    fun setAnalyticsData(analyticsDataList: MutableList<AnalyticsData>) =
        preferences.edit {
            putString(
                SharedPreferenceConstants.ANALYTICS_DATA_LIST_KEY,
                CommonConstants.DEFAULT_GSON.toJson(analyticsDataList)
            )
        }

    fun getPaymentAccountInfo(): MutableList<PaymentAccount> =
        CommonConstants.DEFAULT_GSON.fromJson(
            preferences.getString(
                SharedPreferenceConstants.PAYMENT_ACCOUNT_LIST_KEY,
                "[]"
            ), object : TypeToken<MutableList<PaymentAccount>>() {
            }.type
        )

    fun setPaymentAccountInfo(paymentAccountList: List<PaymentAccount>) {
        val previousAccounts = getPaymentAccountInfo()
        previousAccounts.addAll(paymentAccountList)
        PriyoLog.d(TAG, "${previousAccounts.count()}")
        preferences.edit {
            putString(
                SharedPreferenceConstants.PAYMENT_ACCOUNT_LIST_KEY,
                CommonConstants.DEFAULT_GSON.toJson(previousAccounts.toSet())
            )
        }
    }

    fun getPaymentOptionInfo(): MutableList<PaymentOption> =
        CommonConstants.DEFAULT_GSON.fromJson(
            preferences.getString(
                SharedPreferenceConstants.PAYMENT_OPTION_LIST_KEY,
                "[]"
            ), object : TypeToken<MutableList<PaymentOption>>() {
            }.type
        )

    fun setPaymentOptionInfo(paymentOptionList: List<PaymentOption>) {
        val previousOptions = getPaymentOptionInfo()
        previousOptions.addAll(paymentOptionList)
        PriyoLog.d(TAG, "${previousOptions.count()}")
        preferences.edit {
            putString(
                SharedPreferenceConstants.PAYMENT_OPTION_LIST_KEY,
                CommonConstants.DEFAULT_GSON.toJson(previousOptions.toSet())
            )
        }
    }

    fun getGoPointBalance() =
        BigDecimal(preferences.getString(SharedPreferenceConstants.PRIYO_POINT_KEY, "0"))

    fun setGoPointBalance(goPoint: BigDecimal) = preferences.edit {
        putString(SharedPreferenceConstants.PRIYO_POINT_KEY, goPoint.toString())
    }

    fun getUnseenNotificationCount() =
        BigDecimal(preferences.getString(SharedPreferenceConstants.PRIYO_NOTIFICATION_COUBT_KEY, "0"))

    fun setUnseenNotificationCount(goPoint: Int) = preferences.edit {
        putString(SharedPreferenceConstants.PRIYO_NOTIFICATION_COUBT_KEY, goPoint.toString())
    }

    fun getPointDeficitData(): MutableList<DeficitData> =
        CommonConstants.DEFAULT_GSON.fromJson(
            preferences.getString(
                SharedPreferenceConstants.PRIYO_POINT_DEFICIT_DATA_KEY,
                "[]"
            ), object : TypeToken<MutableList<DeficitData>>() {
            }.type
        )

    fun setDeficitData(deficitDataList: MutableList<DeficitData>) = preferences.edit {
        putString(
            SharedPreferenceConstants.PRIYO_POINT_DEFICIT_DATA_KEY,
            CommonConstants.DEFAULT_GSON.toJson(deficitDataList)
        )
    }

    fun setPriyoTokenExpiryTime(tokenExpiryTime: Long) = preferences.edit {
        putLong(SharedPreferenceConstants.PRIYO_ACCESS_TOKEN_EXPIRE_TIME_KEY, tokenExpiryTime)
    }

    fun setLongTimeToken(isLongTimeToken: Boolean) = preferences.edit {
        putBoolean(SharedPreferenceConstants.PRIYO_ACCESS_TOKEN_IS_LONG_TIME_KEY, isLongTimeToken)
    }

    fun getIPayCheckoutKey() = preferences.getString(SharedPreferenceConstants.IPAY_CHECKOUT_KEY, "")
        ?: ""

    fun removeIPayCheckoutKey() = preferences.edit {
        remove(SharedPreferenceConstants.IPAY_CHECKOUT_KEY)
    }

    fun removeIPayCheckoutStatus(checkoutId: String) = preferences.edit {
        remove("${SharedPreferenceConstants.IPAY_CHECKOUT_KEY}_$checkoutId")
    }

    fun isFeaturedItemAvailable() =
        preferences.contains(SharedPreferenceConstants.FEATURED_CONTENT_LIST_CACHE_KEY)

    fun getFeaturedItemList(): MutableList<FeaturedContent> {
        val featuredItemCache =
            preferences.getString(SharedPreferenceConstants.FEATURED_CONTENT_LIST_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            featuredItemCache,
            object : TypeToken<MutableList<FeaturedContent>>() {
            }.type
        )
    }

    fun setFeaturedItemList(featuredList: MutableList<FeaturedContent>) = preferences.edit {
        putString(
            SharedPreferenceConstants.FEATURED_CONTENT_LIST_CACHE_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(featuredList)
        )
    }

    fun getTrendingPeople(): MutableList<PriyoPeopleData> {
        val featuredItemCache =
            preferences.getString(SharedPreferenceConstants.TRENDING_PEOPLE_LIST_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            featuredItemCache,
            object : TypeToken<MutableList<PriyoPeopleData>>() {
            }.type
        )
    }

    fun setTrendingPeople(featuredList: MutableList<PriyoPeopleData>) = preferences.edit {
        putString(
            SharedPreferenceConstants.TRENDING_PEOPLE_LIST_CACHE_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(featuredList)
        )
    }

    fun getTrendingBusiness(): MutableList<PriyoBusinessData> {
        val featuredItemCache =
            preferences.getString(SharedPreferenceConstants.TRENDING_BUSINESS_LIST_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            featuredItemCache,
            object : TypeToken<MutableList<PriyoBusinessData>>() {
            }.type
        )
    }

    fun setTrendingBusiness(featuredList: MutableList<PriyoBusinessData>) = preferences.edit {
        putString(
            SharedPreferenceConstants.TRENDING_BUSINESS_LIST_CACHE_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(featuredList)
        )
    }

    fun getTrendingTopic(): MutableList<TrendingTopic> {
        val featuredItemCache =
            preferences.getString(SharedPreferenceConstants.TRENDING_TOPIC_LIST_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            featuredItemCache,
            object : TypeToken<MutableList<TrendingTopic>>() {
            }.type
        )
    }

    fun setTrendingTopic(featuredList: MutableList<TrendingTopic>) = preferences.edit {
        putString(
            SharedPreferenceConstants.TRENDING_TOPIC_LIST_CACHE_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(featuredList)
        )
    }

    fun getNearByPeople(): MutableList<NearByPeople> {
        val featuredItemCache =
            preferences.getString(SharedPreferenceConstants.NEARBY_PEOPLE_LIST_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            featuredItemCache,
            object : TypeToken<MutableList<NearByPeople>>() {
            }.type
        )
    }

    fun setNearByPeople(featuredList: MutableList<NearByPeople>) = preferences.edit {
        putString(
            SharedPreferenceConstants.NEARBY_PEOPLE_LIST_CACHE_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(featuredList)
        )
    }

    fun getNearByCoronaNews(): MutableList<AllPinResponse?> {
        val featuredItemCache =
            preferences.getString(SharedPreferenceConstants.NEARBY_CORONA_MAP_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            featuredItemCache,
            object : TypeToken<MutableList<AllPinResponse>>() {
            }.type
        )
    }

    fun setNearByCoronaNews(featuredList: MutableList<AllPinResponse?>) = preferences.edit {
        putString(
            SharedPreferenceConstants.NEARBY_CORONA_MAP_CACHE_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(featuredList)
        )
    }

    fun getTrendingJob(): MutableList<Jobs> {
        val featuredItemCache =
            preferences.getString(SharedPreferenceConstants.TRENDING_JOB_LIST_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            featuredItemCache,
            object : TypeToken<MutableList<Jobs>>() {
            }.type
        )
    }

    fun setTrendingJob(featuredList: MutableList<Jobs>) = preferences.edit {
        putString(
            SharedPreferenceConstants.TRENDING_JOB_LIST_CACHE_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(featuredList)
        )
    }

    fun getNearByOfferList(): MutableList<MyOfferDetail> {
        val featuredItemCache =
            preferences.getString(SharedPreferenceConstants.NEARBY_OFFER_LIST_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            featuredItemCache,
            object : TypeToken<MutableList<MyOfferDetail>>() {
            }.type
        )
    }

    fun setNearByOfferList(featuredList: MutableList<MyOfferDetail>) = preferences.edit {
        putString(
            SharedPreferenceConstants.NEARBY_OFFER_LIST_CACHE_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(featuredList)
        )
    }

    fun getLoopedList(): MutableList<LoopedDetail> {
        val featuredItemCache =
            preferences.getString(SharedPreferenceConstants.LOOPED_LIST_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            featuredItemCache,
            object : TypeToken<MutableList<LoopedDetail>>() {
            }.type
        )
    }

    fun setLoopedList(featuredList: MutableList<LoopedDetail>) = preferences.edit {
        putString(
            SharedPreferenceConstants.LOOPED_LIST_CACHE_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(featuredList)
        )
    }

    fun getRecentAuctionList(): MutableList<AuctionDetail> {
        val featuredItemCache =
            preferences.getString(SharedPreferenceConstants.RECENT_AUCTION_LIST_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            featuredItemCache,
            object : TypeToken<MutableList<AuctionDetail>>() {
            }.type
        )
    }

    fun setRecentAuctionList(featuredList: MutableList<AuctionDetail>) = preferences.edit {
        putString(
            SharedPreferenceConstants.RECENT_AUCTION_LIST_CACHE_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(featuredList)
        )
    }

    fun getRecentOfferList(): MutableList<MyOfferDetail> {
        val featuredItemCache =
            preferences.getString(SharedPreferenceConstants.RECENT_OFFER_LIST_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            featuredItemCache,
            object : TypeToken<MutableList<MyOfferDetail>>() {
            }.type
        )
    }

    fun setRecentOfferList(featuredList: MutableList<MyOfferDetail>) = preferences.edit {
        putString(
            SharedPreferenceConstants.RECENT_OFFER_LIST_CACHE_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(featuredList)
        )
    }


    fun getAdvertisement(): PromoAds {
        val json = preferences.getString(SharedPreferenceConstants.PROMO_ADS_KEY, "{}")
        return CommonConstants.DEFAULT_GSON.fromJson(json, PromoAds::class.java)
    }

    fun setAdvertisement(promoAds: PromoAds) = preferences.edit {
        putString(
            SharedPreferenceConstants.PROMO_ADS_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(promoAds)
        )
    }



    fun setHoroscope(priyoHoroscopeResponse: PriyoHoroscopeResponse) = preferences.edit {
        putString(
            SharedPreferenceConstants.HOROSCOPE_KEY,
            CommonConstants.DEFAULT_GSON.toJson(priyoHoroscopeResponse)
        )
    }

    fun getHoroscope() = CommonConstants.DEFAULT_GSON.fromJson(
        preferences.getString(SharedPreferenceConstants.HOROSCOPE_KEY, "{}"),
        PriyoHoroscopeResponse::class.java
    ) ?: PriyoHoroscopeResponse()

    fun setLatestCacheNews(cacheNews: MutableList<News>) = preferences.edit {
        putString(
            SharedPreferenceConstants.LATEST_NEWS_LIST_CACHE_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(cacheNews)
        )
    }

    fun getLatestCacheNews(): MutableList<News> {
        val latestNewsListCache =
            preferences.getString(SharedPreferenceConstants.LATEST_NEWS_LIST_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            latestNewsListCache,
            object : TypeToken<MutableList<News>>() {
            }.type
        )
    }

    fun setTopCacheNews(cacheNews: MutableList<News>) = preferences.edit {
        putString(
            SharedPreferenceConstants.TOP_NEWS_LIST_CACHE_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(cacheNews)
        )
    }

    fun getTopCacheNews(): MutableList<News> {
        val latestNewsListCache =
            preferences.getString(SharedPreferenceConstants.TOP_NEWS_LIST_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            latestNewsListCache,
            object : TypeToken<MutableList<News>>() {
            }.type
        )
    }

    fun setRecommendedCacheNews(cacheNews: MutableList<News>) = preferences.edit {
        putString(
                SharedPreferenceConstants.RECOMMENDED_NEWS_LIST_CACHE_KEY,
                CommonConstants.DEFAULT_NON_NULL_GSON.toJson(cacheNews)
        )
    }

    fun getRecommendedCacheNews(): MutableList<News> {
        val latestNewsListCache =
                preferences.getString(SharedPreferenceConstants.RECOMMENDED_NEWS_LIST_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
                latestNewsListCache,
                object : TypeToken<MutableList<News>>() {
                }.type
        )
    }

    fun setNearByCacheNews(cacheNews: MutableList<News>) = preferences.edit {
        putString(
            SharedPreferenceConstants.NEARBY_NEWS_LIST_CACHE_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(cacheNews)
        )
    }

    fun getNearByCacheNews(): MutableList<News> {
        val latestNewsListCache =
            preferences.getString(SharedPreferenceConstants.NEARBY_NEWS_LIST_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            latestNewsListCache,
            object : TypeToken<MutableList<News>>() {
            }.type
        )
    }

    fun setTrendingCacheNews(cacheNews: MutableList<News>) = preferences.edit {
        putString(
            SharedPreferenceConstants.TRANDING_NEWS_LIST_CACHE_KEY,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(cacheNews)
        )
    }

    fun getTrendingCacheNews(): MutableList<News> {
        val latestNewsListCache =
            preferences.getString(SharedPreferenceConstants.TRANDING_NEWS_LIST_CACHE_KEY, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            latestNewsListCache,
            object : TypeToken<MutableList<News>>() {
            }.type
        )
    }


    fun setCategorizedCacheNews(key: String,cacheNews: MutableList<News>) = preferences.edit {
        putString(
            key,
            CommonConstants.DEFAULT_NON_NULL_GSON.toJson(cacheNews)
        )
    }

    fun getCategorizedCacheNews(key: String): MutableList<News> {
        val latestNewsListCache =
            preferences.getString(key, "[]")
        return CommonConstants.DEFAULT_GSON.fromJson(
            latestNewsListCache,
            object : TypeToken<MutableList<News>>() {
            }.type
        )
    }

    fun setSecondQuestion(question: Question) = preferences.edit {
        putString(
            SharedPreferenceConstants.SECOND_QUESTION_KEY,
            CommonConstants.DEFAULT_GSON.toJson(question)
        )
    }

    fun getSecondQuestion() = CommonConstants.DEFAULT_GSON.fromJson(
        preferences.getString(SharedPreferenceConstants.SECOND_QUESTION_KEY, "{}"),
        Question::class.java
    ) ?: Question()



    fun setQuizAnswer(id: String) =
        preferences.edit {
            putString("QUIZ_ANSWER", id)
        }

    fun getQuizAnswer() = preferences.getString("QUIZ_ANSWER", "") ?: ""

    fun setQuizId(id: String) =
        preferences.edit {
            putString("QUIZ_ID_KEY", id)
        }

    fun getQuizId() = preferences.getString("QUIZ_ID_KEY", "") ?: ""

    fun removeQuizId() = preferences.edit {
        remove("QUIZ_ID_KEY")
    }

    fun removeQuizAnswer() = preferences.edit {
        remove("QUIZ_ANSWER")
    }



    fun setIsFirstTimeQuiz(id: Boolean) =
        preferences.edit {
            putBoolean("FIRST_TIME_QUIZ_T", id)
        }

    fun isFirstTimeQuiz() = preferences.getBoolean("FIRST_TIME_QUIZ_T", true)

    */


}