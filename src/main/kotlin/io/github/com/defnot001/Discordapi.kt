package io.github.com.defnot001

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import net.fabricmc.api.ModInitializer
import org.slf4j.LoggerFactory

object Discordapi : ModInitializer {
    private val logger = LoggerFactory.getLogger("discord-api")
	const val MOD_ID = "Discord API"

	override fun onInitialize() {
		logger.info("Initializing HTTP Server")

		embeddedServer(Netty, port = 3000) {
			routing {
				get("/") {
					call.respondText("Henlo from Discord HTTP Server!")
				}
			}
		}.start(wait = true)

		logger.info("HTTP Server should be ready...")
	}
}