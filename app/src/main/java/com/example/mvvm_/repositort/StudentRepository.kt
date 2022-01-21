package com.example.mvvm_.repositort

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.mvvm_.model.Student
import org.json.JSONException
import org.json.JSONObject
import java.util.ArrayList

class StudentRepository(val context: Context) {

    private val url = "http://192.168.213.250/nikhil_api/listdata.php"

    private val dataSet: ArrayList<Student> = ArrayList<Student>()
    val data: MutableLiveData<List<Student>> = MutableLiveData()


    var instance: StudentRepository? = null
        get() {
            if (field == null) {
                field = StudentRepository(context)
            }
            return field
        }
        private set

    // Pretend to get data from a webservice or online source
    fun getstudentdata(): MutableLiveData<List<Student>> {

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->


                try {
                    val jsonObject = JSONObject(response)
                    val jsonArray = jsonObject.getJSONArray("students")
                    for (i in 0 until jsonArray.length()) {

                        val jsonObjec = jsonArray.getJSONObject(i)

//                        Toast.makeText(context, jsonObjec.toString(), Toast.LENGTH_SHORT).show()

                        dataSet.add(Student(
                            jsonObjec.getString("email"),
                            jsonObjec.getString("id"),
                            jsonObjec.getString("name"),
                            jsonObjec.getString("password")))


                    }

                } catch (e: JSONException) {
                    e.printStackTrace()
                }
                data.setValue(dataSet)

            }
        ) { error ->
            Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show()
        }
        val requestQueue = Volley.newRequestQueue(context)
        stringRequest.retryPolicy =
            DefaultRetryPolicy(20 * 1000, 2, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)
        requestQueue.add(stringRequest)

        return data

    }


}