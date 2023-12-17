package com.khantnyar.odoo_rest

data class BaseResponse<T>(
    val success: Boolean,
    val message: String,
    val responseCode: Int,
    val object_name: String,
    val permissions: Permissions,
    val model_id: Int,
    val record_id: Int?,
    val domain: String = "",
    val fields: String = "",
    val data: List<T>,
    val result: List<T>? = null
)

data class Permissions(
    val read: Boolean,
    val write: Boolean,
    val delete: Boolean,
    val create: Boolean
)