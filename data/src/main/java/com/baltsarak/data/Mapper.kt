package com.baltsarak.data

import com.baltsarak.data.models.MusicOfferDto
import com.baltsarak.data.models.TicketDto
import com.baltsarak.data.models.TicketOfferDto
import com.baltsarak.domain.entities.MusicOffer
import com.baltsarak.domain.entities.Ticket
import com.baltsarak.domain.entities.TicketOffer
import org.threeten.bp.Duration
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter
import javax.inject.Inject

class Mapper @Inject constructor() {

    fun mapMusicOffer(musicDto: MusicOfferDto): MusicOffer {
        return MusicOffer(
            title = musicDto.title,
            town = musicDto.town,
            price = musicDto.price.value
        )
    }

    fun mapTicketOffer(ticketDto: TicketOfferDto): TicketOffer {
        return TicketOffer(
            id = ticketDto.id,
            title = ticketDto.title,
            timeRange = ticketDto.timeRange.joinToString(separator = " "),
            price = ticketDto.price.value
        )
    }

    fun mapTicket(ticketDto: TicketDto): Ticket {
        return Ticket(
            id = ticketDto.id,
            badge = ticketDto.badge,
            price = ticketDto.price.value,
            departureTime = formatedTime(ticketDto.departure.date),
            arrivalTime = formatedTime(ticketDto.arrival.date),
            duration = calculateHoursDifference(ticketDto.departure.date, ticketDto.arrival.date),
            departureAirport = ticketDto.departure.airport,
            arrivalAirport = ticketDto.arrival.airport,
            hasTransfer = ticketDto.hasTransfer
        )
    }

    private fun formatedTime(date: String): String {
        val dateTime = LocalDateTime.parse(date)
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        return dateTime.format(formatter)
    }

    private fun calculateHoursDifference(startDateTime: String, endDateTime: String): String {
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
        val start = LocalDateTime.parse(startDateTime, formatter)
        val end = LocalDateTime.parse(endDateTime, formatter)
        val duration = Duration.between(start, end)
        return duration.toHours().toString()
    }
}

