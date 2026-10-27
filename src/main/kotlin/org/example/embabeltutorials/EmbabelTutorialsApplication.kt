package org.example.embabeltutorials

import com.embabel.agent.core.AgentPlatform
import com.embabel.agent.core.ProcessOptions
import com.embabel.agent.domain.io.UserInput
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EmbabelTutorialsApplication

fun main(args: Array<String>) {
    val context = runApplication<EmbabelTutorialsApplication>(*args)
    val agentPlatform = context.getBean(AgentPlatform::class.java)

    val input = "How did Arsenal do this weekend?"
    val agent = agentPlatform.agents().first { it.name.contains("FootballScout", ignoreCase = true) }
    val process = agentPlatform.runAgentFrom(
        agent = agent,
        processOptions = ProcessOptions(),
        bindings = mapOf("userInput" to UserInput(input)),
    )

    println(process.lastResult())
}
