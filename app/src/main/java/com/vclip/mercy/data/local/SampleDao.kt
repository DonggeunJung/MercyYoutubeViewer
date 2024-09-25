/*********************************************
 * Copyright mercy project 2023
 * All rights reserved
 *********************************************/
package com.vclip.mercy.data.local

import androidx.room.*
@Dao
interface SampleDao {

    @Query("SELECT * FROM mercy_db")
    suspend fun getMercyEntity(): List<SampleEntity>

    @Query("SELECT * FROM mercy_db WHERE id = :id")
    suspend fun getMercyEntityById(id: Int): SampleEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMercyEntity(movie: SampleEntity)

    @Delete
    suspend fun deleteMercyEntity(movie: SampleEntity)
}