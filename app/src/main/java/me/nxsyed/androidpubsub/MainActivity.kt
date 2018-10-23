package me.nxsyed.androidpubsub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.pubnub.api.PNConfiguration
import com.pubnub.api.PubNub
import com.pubnub.api.models.consumer.PNStatus
import com.pubnub.api.models.consumer.pubsub.PNMessageResult
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pnConfiguration = PNConfiguration()
        pnConfiguration.subscribeKey = "ENTER_SUBSCRIBE_KEY"
        pnConfiguration.publishKey = "ENTER_PUBLISH_KEY"
        pnConfiguration.setSecretKey("true")
        val pubNub = PubNub(pnConfiguration)

        pubNub.addListener( new SubscribeCallback() {
            @Override
            fun status(pubnub: PubNub, status: PNStatus) {
            }

            @Override
            fun message(pubnub: PubNub, message: PNMessageResult) {
                val message = message.message.asJsonObject

            }
        })
        pubNub.subscribe()
                .channels(Arrays.asList("")) // subscribe to channels
                .execute()

    }

}
