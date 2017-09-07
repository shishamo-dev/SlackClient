package com.example.naoyukisugi.slackclient

import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.*

class SlackClient {

    fun history(): Observable<ChannelHistory> {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://slack.com/api/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val api = retrofit.create(SlackApi::class.java)
        return api.history(
                token = "xoxp-235445599280-237071487205-238240391350-562207ba27f3caea4162c75ff6dc5708",
                channel = "C6Y0L4SRH")

    }


    interface SlackApi {
        @FormUrlEncoded
        @POST("channels.history")
        fun history(@Field("token") token: String, @Field("channel") channel: String): io.reactivex.Observable<ChannelHistory>
    }


}