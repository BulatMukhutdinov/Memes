package tat.mukhutdinov.memes.list

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import tat.mukhutdinov.memes.list.domain.ListInteractor
import tat.mukhutdinov.memes.list.domain.boundary.ListDomain
import tat.mukhutdinov.memes.list.domain.boundary.ListGateway
import tat.mukhutdinov.memes.list.gateway.ListRemoteGateway
import tat.mukhutdinov.memes.list.gateway.boundary.ListApi
import tat.mukhutdinov.memes.list.ui.ListRetainedViewModel
import tat.mukhutdinov.memes.list.ui.boundary.ListViewModel

object ListModule {

    val module = module {
        viewModel<ListViewModel> {
            ListRetainedViewModel(get())
        }

        factory<ListDomain> {
            ListInteractor(get())
        }

        factory<ListGateway> {
            ListRemoteGateway(get())
        }

        factory {
            get<Retrofit>().create(ListApi::class.java)
        }
    }
}