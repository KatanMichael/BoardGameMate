package com.michael.boardgamemate.models.boardGameModels

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "games_table")
data class Game(
    @Ignore var artists: List<String>? = null,
    @Ignore var average_user_rating: Double = 0.0,
    @Ignore var categories: List<Any>? = null,
    @Ignore var description: String = "",
    @Ignore var description_preview: String = "",
    @Ignore var designers: List<String>? = null,
    @Ignore var developers: List<Any>? = null,
    @Ignore var discount: String = "",
    @Ignore var historical_low_price: Double = 0.0,
    @PrimaryKey(autoGenerate = false) var id: String = "0",
    @Ignore var image_url: String = "0",
    @Ignore var images: Images ? = null,
    @Ignore var matches_specs: Any ? = null,
    @Ignore var max_players: Int? = null,
    @Ignore var max_playtime: Int? = null,
    @Ignore var mechanics: List<Any>? = null,
    @Ignore var min_age: Int? = null,
    @Ignore var min_players: Int? = null,
    @Ignore var min_playtime: Int? = null,
    @Ignore var msrp: String? = null,
    var name: String? = "",
    @Ignore var names: List<Any>? = null,
    @Ignore var num_user_ratings: Int? = null,
    @Ignore var official_url: String? = null,
    @Ignore var price: String? = null,
    @Ignore var primary_publisher: String? = null,
    @Ignore var publishers: List<String>? = null,
    @Ignore var reddit_all_time_count: Int? = null,
    @Ignore var reddit_day_count: Int? = null,
    @Ignore var reddit_week_count: Int? = null,
    @Ignore var rules_url: String? = null,
    @Ignore var size_depth: Double? = null,
    @Ignore var size_height: Double? = null,
    @Ignore var size_units: String? = null,
    @Ignore var size_width: Double? = null,
    @Ignore var spec: List<Any>? = null,
    @Ignore var thumb_url: String? = null,
    @Ignore var url: String? = null,
    @Ignore var weight_amount: Double? = null,
    @Ignore var weight_units: String? = null,
    @Ignore var year_published: Int? = null
)