package org.d3if3041.universerthings.model

import org.d3if3041.universerthings.R
import org.d3if3041.universerthings.data.UniverseEntity

fun UniverseEntity.cariUniverse(): HasilUniverse {
    val universe = namaPlanet
    val informasiPlanet = if (universe.equals("Merkurius", ignoreCase = true)) {
        R.string.infor_merkurius
    } else if (universe.equals("Venus", ignoreCase = true)) {
        R.string.infor_venus
    } else if (universe.equals("Bumi", ignoreCase = true)) {
        R.string.infor_bumi
    } else if (universe.equals("Mars", ignoreCase = true)) {
        R.string.infor_mars
    } else if (universe.equals("Jupiter", ignoreCase = true)) {
        R.string.infor_jupiter
    } else if (universe.equals("Saturnus", ignoreCase = true)) {
        R.string.infor_saturnus
    } else if (universe.equals("Uranus", ignoreCase = true)) {
        R.string.infor_uranus
    } else if (universe.equals("Neptunus", ignoreCase = true)) {
        R.string.infor_neptunus
    } else if (universe.equals("Andromeda", ignoreCase = true)) {
        R.string.infor_andromeda
    } else if (universe.equals("Bima Sakti", ignoreCase = true)) {
        R.string.infor_bima
    } else if (universe.equals("Black Eye", ignoreCase = true)) {
        R.string.infor_blackeye
    } else if (universe.equals("Smiley", ignoreCase = true)) {
        R.string.infor_smiley
    } else if (universe.equals("Ursa Mayor", ignoreCase = true)) {
        R.string.infor_ursamayor
    } else if (universe.equals("Orionid", ignoreCase = true)) {
        R.string.infor_orionid
    } else if (universe.equals("Perseid", ignoreCase = true)) {
        R.string.infor_orionid
    } else if (universe.equals("Quadrantid", ignoreCase = true)) {
        R.string.infor_orionid
    } else {
        R.string.tidak_diketahui
    }
    val imgPlanet = if (universe.equals("Merkurius", ignoreCase = true)) {
        R.drawable.merkurius
    } else if (universe.equals("Venus", ignoreCase = true)) {
        R.drawable.venus
    } else if (universe.equals("Bumi", ignoreCase = true)) {
        R.drawable.bumi
    } else if (universe.equals("Mars", ignoreCase = true)) {
        R.drawable.mars
    } else if (universe.equals("Jupiter", ignoreCase = true)) {
        R.drawable.jupiter
    } else if (universe.equals("Saturnus", ignoreCase = true)) {
        R.drawable.saturnus
    } else if (universe.equals("Uranus", ignoreCase = true)) {
        R.drawable.uranus
    } else if (universe.equals("Neptunus", ignoreCase = true)) {
        R.drawable.neptunus
    } else if (universe.equals("Andromeda", ignoreCase = true)) {
        R.drawable.andromeda
    } else if (universe.equals("Bima Sakti", ignoreCase = true)) {
        R.drawable.bimasakti
    } else if (universe.equals("Black Eye", ignoreCase = true)) {
        R.drawable.blackeye
    } else if (universe.equals("Smiley", ignoreCase = true)) {
        R.drawable.smiley
    } else if (universe.equals("Ursa Mayor", ignoreCase = true)) {
        R.drawable.ursamayor
    } else if (universe.equals("Orionid", ignoreCase = true)) {
        R.drawable.orionid
    } else if (universe.equals("Perseid", ignoreCase = true)) {
        R.drawable.perseid
    } else if (universe.equals("Quadrantid", ignoreCase = true)) {
        R.drawable.quadrantid
    } else {
        R.drawable.baseline_heart_broken_24
    }
    return HasilUniverse(universe, informasiPlanet, imgPlanet)
}