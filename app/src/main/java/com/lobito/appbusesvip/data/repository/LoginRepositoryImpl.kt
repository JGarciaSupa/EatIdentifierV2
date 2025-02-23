package com.lobito.appbusesvip.data.repository

import com.lobito.appbusesvip.data.local.dao.UserDao
import com.lobito.appbusesvip.data.local.model.UserEntity
import com.lobito.appbusesvip.data.remote.service.AppbusesService
import com.lobito.appbusesvip.domain.model.User
import com.lobito.appbusesvip.domain.repository.UserRepository

class LoginRepositoryImpl(private val userDao: UserDao) : UserRepository {

    override suspend fun insertUser(user: User): User {
        val entity = UserEntity(username = user.username, password = user.password)
        val userId = userDao.insert(entity)
        return User(userId, user.username, user.password)
    }

    override suspend fun getUserByUsername(username: String): User? {
        val entity = userDao.getUserByUsername(username)
        return entity?.let { User(it.id, it.username, it.password) }
    }

    override suspend fun updateFlagById(userId: Long, flag: Int) {
        userDao.updateFlagById(userId, flag)
    }

    override suspend fun getLoggedInUser(): User? {
        val entity = userDao.getLoggedInUser()
        return entity?.let { User(it.id, it.username, it.password) }
    }

    override suspend fun logoutUser() {
        val loggedInUser = userDao.getLoggedInUser()
        loggedInUser?.let {
            userDao.updateFlagById(it.id, 1) // Cambiamos el flag a 1 (sesión terminada)
        }
    }


}