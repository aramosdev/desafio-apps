package br.com.aramosdev.infoglobo.model.api;

import java.util.List;

import br.com.aramosdev.infoglobo.model.news.News;
import io.reactivex.Flowable;
import retrofit2.http.GET;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public interface Services {

    @GET("Infoglobo/desafio-apps/master/capa.json")
    Flowable<List<News>> getNews();
}
