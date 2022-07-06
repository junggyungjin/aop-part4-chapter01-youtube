package fastcampus.aop.part3.chapter01_youtube.service

import fastcampus.aop.part3.chapter01_youtube.dto.VideoDto
import retrofit2.Call
import retrofit2.http.GET

interface VideoService {

    @GET("/v3/8d000cfd-5eb3-45dd-bef3-858ae0e233e8")
    fun listVideos(): Call<VideoDto>
}