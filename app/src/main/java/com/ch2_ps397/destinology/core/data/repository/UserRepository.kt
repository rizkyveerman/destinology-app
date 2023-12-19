package com.ch2_ps397.destinology.core.data.repository

import com.ch2_ps397.destinology.core.data.source.local.UserPreferences
import com.ch2_ps397.destinology.core.data.source.remote.network.ApiService
import com.ch2_ps397.destinology.core.data.source.remote.response.DestinologyCreateUserResponse
import com.ch2_ps397.destinology.core.data.source.remote.response.DestinologyLoginUserResponse
import com.ch2_ps397.destinology.core.model.MUser
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

class UserRepository(
    private val token: String?,
    private val apiService: ApiService,
    private val userPreferences: UserPreferences
) {
    fun getUserToken() : String {
        return token!!
    }
    suspend fun createAccountUser(
        email: String,
        fullName: String,
        username: String,
        password: String
    ) : Response<DestinologyCreateUserResponse> {
        val newUser = MUser(
            email = email,
            full_name = fullName,
            username = username,
            password = password
        )
        val client = apiService.createAccountUser(newUser)
        client.clone().enqueue(object : Callback<DestinologyCreateUserResponse> {
            override fun onResponse(
                call: Call<DestinologyCreateUserResponse>,
                response: Response<DestinologyCreateUserResponse>
            ) {
            }

            override fun onFailure(call: Call<DestinologyCreateUserResponse>, t: Throwable) {
            }

        })

        return client.awaitResponse()
    }
    @OptIn(DelicateCoroutinesApi::class)
    suspend fun loginUser(email: String, password: String) {
        val loginUser = MUser(
            email = email,
            password = password
        )
        val client = apiService.loginUser(loginUser)
        client.clone().enqueue(object : Callback<DestinologyLoginUserResponse> {
            override fun onResponse(
                call: Call<DestinologyLoginUserResponse>,
                response: Response<DestinologyLoginUserResponse>
            ) {
                GlobalScope.launch {
                    userPreferences.saveToken(response.body()?.accessToken.toString())
                }
            }

            override fun onFailure(call: Call<DestinologyLoginUserResponse>, t: Throwable) {
//                TODO("Not yet implemented")
            }

        })
    }

}