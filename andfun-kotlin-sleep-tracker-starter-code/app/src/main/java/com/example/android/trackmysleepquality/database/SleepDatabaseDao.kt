/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.trackmysleepquality.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface SleepDatabaseDao {

    /** 코드에서 호출 할 수 있는 삽입 함수에 대한 함수 정의
     * 매개변수로 삽입 할 내용을 지정
     * Entity 클래스의 SleepNight의 인스턴스
     * Kotiln 개체에서 데이터베이스 값 행으로 파싱된다.
     * 따라서, insert를 호출하면 room은 Entity 객체에서 행을 생성하고 데이터베이스에 삽입한다.*/
    @Insert
    fun insert(night: SleepNight)

    @Update
    fun update(night: SleepNight)

    /** 데이터베이스 읽기 작업은 쿼리문으로 구현해야한다.
     * Anroid Studio가 쿼리 구문 오류와 오타를 확인한다. */
    @Query("SELECT * FROM daily_sleep_quality_table WHERE nightId = :key")
    fun get(key: Long): SleepNight?

    /** 테이블을 삭제하지 않고 모든 행을 삭제한다. */
    @Query("DELETE FROM daily_sleep_quality_table")
    fun clear()

    /** Room은 데이터베이스가 업데이트 될 때마다 라이브 데이터가 업데이트 되도록 한다.*/
    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC")
    fun getAllNights(): LiveData<List<SleepNight>>

    @Query("SELECT * FROM daily_sleep_quality_table ORDER BY nightId DESC LIMIT 1")
    fun getTonight(): SleepNight?


}
