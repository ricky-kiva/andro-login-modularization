package com.rickyslash.core

class UserRepository(private val sesi: com.rickyslash.core.SessionManager) {

    companion object {
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(sesi: com.rickyslash.core.SessionManager): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(sesi)
            }
    }

    fun loginUser(username: String) {
        sesi.createLoginSession()
        sesi.saveToPreference(com.rickyslash.core.SessionManager.KEY_USERNAME, username)
    }

    fun getUser() = sesi.getFromPreference(com.rickyslash.core.SessionManager.KEY_USERNAME)

    fun isUserLogin() = sesi.isLogin

    fun logoutUser() = sesi.logout()
}