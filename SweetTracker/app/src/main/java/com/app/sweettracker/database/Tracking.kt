package com.app.sweettracker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "tracking_table")
data class Tracking(

        @PrimaryKey
        var parcelCompanyCode: String ,

        @ColumnInfo(name = "parcel_company_name")
        var parcelCompanyName: String,

        @ColumnInfo(name = "parcel_invoice")
        var parcelInvoice: String,

        @ColumnInfo(name = "parcel_level")
        var parcelLevel: Int,

        @ColumnInfo(name = "parcel_deliver_time")
        var parcelDeliverTime: String,

        @ColumnInfo(name = "purchase_item_img")
        var purchaseItemImg: String,

        @ColumnInfo(name = "purchase_item_name")
        var purchaseItemName: String,

        @ColumnInfo(name = "purchase_item_date")
        var purchaseItemDate: String



)