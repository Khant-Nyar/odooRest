package com.khantnyar.odoo_rest.model


import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("active") var active: Boolean?,
    @SerializedName("available_in_pos") var availableInPos: Boolean?,
    @SerializedName("available_threshold") var availableThreshold: Double?,
    @SerializedName("can_image_1024_be_zoomed") var canImage1024BeZoomed: Boolean?,
    @SerializedName("categ_id") var categId: List<CategId?>?,
    @SerializedName("color") var color: Int?,
    @SerializedName("company_id") var companyId: List<Any?>?,
    @SerializedName("create_date") var createDate: String?,
    @SerializedName("create_uid") var createUid: List<CreateUid?>?,
    @SerializedName("custom_message") var customMessage: String?,
    @SerializedName("default_code") var defaultCode: String?,
    @SerializedName("description") var description: Boolean?,
    @SerializedName("description_picking") var descriptionPicking: Boolean?,
    @SerializedName("description_pickingin") var descriptionPickingin: Boolean?,
    @SerializedName("description_pickingout") var descriptionPickingout: Boolean?,
    @SerializedName("description_purchase") var descriptionPurchase: Boolean?,
    @SerializedName("description_sale") var descriptionSale: Boolean?,
    @SerializedName("elastic_field") var elasticField: Boolean?,
    @SerializedName("expense_policy") var expensePolicy: String?,
    @SerializedName("has_configurable_attributes") var hasConfigurableAttributes: Boolean?,
    @SerializedName("hs_code") var hsCode: Boolean?,
    @SerializedName("id") var id: Int?,
    @SerializedName("image_1024") var image1024: String?,
    @SerializedName("image_128") var image128: String?,
    @SerializedName("image_1920") var image1920: String?,
    @SerializedName("image_256") var image256: String?,
    @SerializedName("image_512") var image512: String?,
    @SerializedName("inventory_availability") var inventoryAvailability: String?,
    @SerializedName("invoice_policy") var invoicePolicy: String?,
    @SerializedName("is_mobikul_available") var isMobikulAvailable: Boolean?,
    @SerializedName("is_published") var isPublished: Boolean?,
    @SerializedName("list_price") var listPrice: Double?,
    @SerializedName("message_follower_ids") var messageFollowerIds: List<MessageFollowerId?>?,
    @SerializedName("message_ids") var messageIds: List<MessageId?>?,
    @SerializedName("message_main_attachment_id") var messageMainAttachmentId: List<Any?>?,
    @SerializedName("mobikul_status") var mobikulStatus: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("pos_categ_id") var posCategId: List<PosCategId?>?,
    @SerializedName("product_add_mode") var productAddMode: String?,
    @SerializedName("product_variant_ids") var productVariantIds: List<ProductVariantId?>?,
    @SerializedName("purchase_line_warn") var purchaseLineWarn: String?,
    @SerializedName("purchase_line_warn_msg") var purchaseLineWarnMsg: Boolean?,
    @SerializedName("purchase_method") var purchaseMethod: String?,
    @SerializedName("purchase_ok") var purchaseOk: Boolean?,
    @SerializedName("rating_last_value") var ratingLastValue: Double?,
    @SerializedName("rental") var rental: Boolean?,
    @SerializedName("sale_delay") var saleDelay: Double?,
    @SerializedName("sale_line_warn") var saleLineWarn: String?,
    @SerializedName("sale_line_warn_msg") var saleLineWarnMsg: Boolean?,
    @SerializedName("sale_ok") var saleOk: Boolean?,
    @SerializedName("seller_ids") var sellerIds: List<SellerId?>?,
    @SerializedName("sequence") var sequence: Int?,
    @SerializedName("service_to_purchase") var serviceToPurchase: Boolean?,
    @SerializedName("service_type") var serviceType: String?,
    @SerializedName("to_weight") var toWeight: Boolean?,
    @SerializedName("tracking") var tracking: String?,
    @SerializedName("type") var type: String?,
    @SerializedName("uom_id") var uomId: List<UomId?>?,
    @SerializedName("uom_po_id") var uomPoId: List<UomPoId?>?,
    @SerializedName("variant_seller_ids") var variantSellerIds: List<VariantSellerId?>?,
    @SerializedName("volume") var volume: Double?,
    @SerializedName("website_description") var websiteDescription: Boolean?,
    @SerializedName("website_id") var websiteId: List<Any?>?,
    @SerializedName("website_meta_description") var websiteMetaDescription: Boolean?,
    @SerializedName("website_meta_keywords") var websiteMetaKeywords: Boolean?,
    @SerializedName("website_meta_og_img") var websiteMetaOgImg: Boolean?,
    @SerializedName("website_meta_title") var websiteMetaTitle: Boolean?,
    @SerializedName("website_sequence") var websiteSequence: Int?,
    @SerializedName("website_size_x") var websiteSizeX: Int?,
    @SerializedName("website_size_y") var websiteSizeY: Int?,
    @SerializedName("weight") var weight: Double?,
    @SerializedName("write_date") var writeDate: String?,
    @SerializedName("write_uid") var writeUid: List<WriteUid?>?
) {
    data class CategId(
        @SerializedName("id") var id: Int?
    )

    data class CreateUid(
        @SerializedName("id") var id: Int?
    )

    data class MessageFollowerId(
        @SerializedName("id") var id: Int?
    )

    data class MessageId(
        @SerializedName("id") var id: Int?
    )

    data class PosCategId(
        @SerializedName("id") var id: Int?
    )

    data class ProductVariantId(
        @SerializedName("id") var id: Int?,
        @SerializedName("name") var name: String?
    )

    data class SellerId(
        @SerializedName("id") var id: Int?
    )

    data class UomId(
        @SerializedName("id") var id: Int?
    )

    data class UomPoId(
        @SerializedName("id") var id: Int?
    )

    data class VariantSellerId(
        @SerializedName("id") var id: Int?
    )

    data class WriteUid(
        @SerializedName("id") var id: Int?
    )
}