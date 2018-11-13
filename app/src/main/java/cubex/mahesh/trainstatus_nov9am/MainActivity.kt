package cubex.mahesh.trainstatus_nov9am

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import cubex.mahesh.trainstatus_nov9am.beans.TrainStatusBean
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getTrainStatus.setOnClickListener {
                var r = Retrofit.Builder().
                    addConverterFactory(GsonConverterFactory.create()).
                    baseUrl("https://api.railwayapi.com/").
                    build()
        var api =  r.create(TrainStatusAPI::class.java)
        var call = api.getTrainStatus(et1.text.toString(),
                                                et2.text.toString())
         call.enqueue(object : Callback<TrainStatusBean> {

             override fun onResponse(call: Call<TrainStatusBean>,
                                     response: Response<TrainStatusBean>) {
                Toast.makeText(this@MainActivity,
                       "success",Toast.LENGTH_LONG).show()

                 var bean = response.body()
                 var temp_list = mutableListOf<String>()
                 temp_list.add("Train Name : "+bean!!.train.name)
                 temp_list.add("Position : "+bean!!.position)

                for(st in bean.route)
                {
                    temp_list.add("Sta Name:"+st.station.name+"\n"+
                    "Acct Arr:"+st.actarr+"\t"+"Sch Arr:"+st.scharr+"\n"+
                    "Acct Dep:"+st.actdep+"\t"+"Sch Dep:"+st.schdep+"\n"+
                            st.status)
                }
                var adapter = ArrayAdapter<String>(
                    this@MainActivity,
                    R.layout.indiview,temp_list)
                 lview.adapter = adapter


             }
      override fun onFailure(call: Call<TrainStatusBean>,
                                    t: Throwable) {
          Toast.makeText(this@MainActivity,
              "Fail",Toast.LENGTH_LONG).show()
             }

         })

        }

    }
}
