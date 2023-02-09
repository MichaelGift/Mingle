package com.flexcode.wedate.auth.data.local.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.flexcode.wedate.auth.data.models.User
import com.flexcode.wedate.common.utils.Constants
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthDataStore(private val dataStore: DataStore<Preferences>, private val gson:Gson) {

    suspend fun saveUserName(name:String){
        dataStore.edit { pref->
            pref[Constants.USER_NAME_KEY] = setOf(name)
        }
    }

    val getUserName : Flow<String> =dataStore.data.map { pref ->
        (pref[Constants.USER_NAME_KEY]?: "").toString()
    }

    suspend fun saveUserEmail(name:String){
        dataStore.edit { pref->
            pref[Constants.USER_EMAIL_KEY] = setOf(name)
        }
    }
    val getUserEmail : Flow<String> =dataStore.data.map { pref ->
        (pref[Constants.USER_EMAIL_KEY]?: "").toString()
    }

    suspend fun saveUserPhone(name:String){
        dataStore.edit { pref->
            pref[Constants.USER_PHONE_KEY] = setOf(name)
        }
    }

    val getUserPhone : Flow<String> =dataStore.data.map { pref ->
        (pref[Constants.USER_PHONE_KEY]?: "").toString()
    }


    suspend fun saveGender(gender:String){
        dataStore.edit { pref ->
            pref[Constants.GENDER_KEY] = setOf(gender)
        }
    }

    val getUserGender: Flow<String>  = dataStore.data.map { pref ->
        (pref[Constants.GENDER_KEY]?: "[Male]").toString()
    }

    suspend fun saveInterestIn(interestedIn:String){
        dataStore.edit { pref->
            pref[Constants.INTEREST_KEY] = setOf(interestedIn)
        }
    }

    val getUserInterest: Flow<String> =dataStore.data.map { pref->
        (pref[Constants.INTEREST_KEY]?: "[Women]").toString()
    }

    suspend fun saveUserPwd(searchingFor:String){
        dataStore.edit { pref->
            pref[Constants.PASSWORD] = setOf(searchingFor)
        }
    }

    val getUserPwd: Flow<String> =dataStore.data.map { pref->
        (pref[Constants.PASSWORD]?: "").toString()
    }

    suspend fun saveYearOfBirth(year:String){
        dataStore.edit {
            it[Constants.Y_O_B_KEY] = setOf(year)
        }
    }

    val getYearOfBirth: Flow<String> = dataStore.data.map { pref->
        (pref[Constants.Y_O_B_KEY]?: "01/01/2004").toString()
    }

    suspend fun saveAge(age:String){
        dataStore.edit {
            it[Constants.AGE_KEY] = setOf(age)
        }
    }

    val getUserAge: Flow<String> = dataStore.data.map { pref->
        (pref[Constants.AGE_KEY]?: "").toString()
    }


    //// save the entire user data as an object
    suspend fun saveUserInfo(user: User){
        dataStore.edit { pref ->
            pref[Constants.USER_DATA] = setOf(gson.toJson(user))
        }
    }

    val getUserInfo: Flow<String> = dataStore.data.map { pref->
        (pref[Constants.USER_DATA]?: "").toString()
    }

}