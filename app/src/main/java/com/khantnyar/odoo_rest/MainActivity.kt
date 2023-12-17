package com.khantnyar.odoo_rest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.khantnyar.odoo_rest.OdooRetrofit.apiService
import com.khantnyar.odoo_rest.model.Products
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val requestApi: OdooApiService by lazy {
        apiService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        getAllProductSearch()
        Search<Products>("product.template", "['id','name']", "[('active','=',True)]",0,30,
            { handleApiResponse(it) },
            { handleError(it) }
        )
    }

    private fun <T> Search(
        model: String,
        fields: String,
        domain: String,
        offset: Int,
        limit: Int,
        onSuccess: (Response<BaseResponse<T>>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        Log.d("exec", "performSearch: ")
        lifecycleScope.launch(Dispatchers.Main) {
            try {
                withContext(Dispatchers.IO) {
                    val call: Call<BaseResponse<T>> = requestApi.search<T>(model, domain, fields)
                    call.enqueue(object : Callback<BaseResponse<T>> {
                        override fun onResponse(call: Call<BaseResponse<T>>, response: Response<BaseResponse<T>>) {
                            onSuccess(response)
                            Log.i("exec", "Search: $response")
                        }
                        override fun onFailure(call: Call<BaseResponse<T>>, t: Throwable) {
                            onError(t)
                        }
                    })
                }
            } catch (e: Exception) {
                // Log the exception for debugging
                e.printStackTrace()
                onError(e)
            }
        }
    }


    // Example functions for different API calls
    private fun getAllProductSearch() {
        Search<Products>("product.template", "['id','name']", "[('active','=',True)]",0,30,
            { handleApiResponse(it) },
            { handleError(it) }
        )
    }

    private fun <T> handleApiResponse(response: Response<BaseResponse<T>>) {
        // Handle the response accordingly
        if (response.isSuccessful) {
            val baseResponse = response.body()
            Log.d("exec", "handleApiResponse: ${response.body()?.data}")
            Toast.makeText(this, "here is is ", Toast.LENGTH_SHORT).show()
            Log.d("exec", "handleApiResponse: $baseResponse")
            // Example: Update UI or perform further actions
        } else {
            // Handle error case
            // Example: Show an error message
        }
    }

    private fun handleError(error: Throwable) {
        // Handle error case
        error.printStackTrace()
    }

}



//lifecycleScope.launch(Dispatchers.Main){
//    val model = "product.template"
//    val fields = "['id','product_variant_ids','name','image_256']"
//    val domain = "[('active','=',True),('categ_id.complete_name','ilike','All / Saleable')]"
//    val getAllProducts = requestApi.search<Products>(model, fields, domain)
//    handleApiResponse(getAllProducts)
//}
//
//private fun handleApiResponse(allProducts: Call<BaseResponse<Products>>) {
//
//}