package com.app.sweettracker

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseGetData(

        @Expose
        @SerializedName("parcelCompanyCode")
        var parcelCompanyCode: String,

        @Expose
        @SerializedName("parcelCompanyName")
        var parcelCompanyName: String,

        @Expose
        @SerializedName("parcelInvoice")
        var parcelInvoice: String,

        @Expose
        @SerializedName("parcelLevel")
        var parcelLevel: Int,

        @Expose
        @SerializedName("parcelDeliverTime")
        var parcelDeliverTime: String,

        @Expose
        @SerializedName("purchaseItemImg")
        var purchaseItemImg: String,

        @Expose
        @SerializedName("purchaseItemName")
        var purchaseItemName: String,

        @Expose
        @SerializedName("purchaseItemDate")
        var purchaseItemDate: String,

        @Expose
        @SerializedName("trackingDetail")
        var trackingDetail: List<Items>



)

data class Items (

        @Expose
        @SerializedName("time")
        var time: String,

        @Expose
        @SerializedName("where")
        var where: String,

        @Expose
        @SerializedName("status")
        var status: String

)

