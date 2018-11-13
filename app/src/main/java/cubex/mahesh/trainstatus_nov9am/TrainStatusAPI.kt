package cubex.mahesh.trainstatus_nov9am

import cubex.mahesh.trainstatus_nov9am.beans.TrainStatusBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TrainStatusAPI {

    @GET("v2/live/train/{tno}/date/{dt}/apikey/0rfz4cfpdo")
    fun getTrainStatus(@Path("tno") tno:String,
               @Path("dt") dt:String):Call<TrainStatusBean>
}