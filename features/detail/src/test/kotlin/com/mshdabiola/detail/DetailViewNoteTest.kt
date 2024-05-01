/*
 *abiola 2022
 */

package com.mshdabiola.detail

import androidx.lifecycle.SavedStateHandle
import com.mshdabiola.data.repository.fake.FakeNoteRepository
import com.mshdabiola.detail.navigation.DETAIL_ID_ARG
import com.mshdabiola.testing.repository.TestUserDataRepository
import com.mshdabiola.testing.util.MainDispatcherRule
import org.junit.Before
import org.junit.Rule

class DetailViewNoteTest {
    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val userDataRepository = TestUserDataRepository()

    private lateinit var viewModel: DetailViewModel

    @Before
    fun setup() {
        viewModel = DetailViewModel(
            savedStateHandle = SavedStateHandle(mapOf(DETAIL_ID_ARG to 4)),
            noteRepository = FakeNoteRepository(),
        )
    }

//    @Test
//    fun stateIsInitiallyLoading() = runTest {
//    }

//    @Test
//    fun oneBookmark_showsInFeed() = runTest {
//        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.feedUiState.collect() }
//
//        newsRepository.sendNewsResources(newsResourcesTestData)
//        userDataRepository.updateNewsResourceBookmark(newsResourcesTestData[0].id, true)
//        val item = viewModel.feedUiState.value
//        assertIs<Success>(item)
//        assertEquals(item.feed.size, 1)
//
//        collectJob.cancel()
//    }
}
