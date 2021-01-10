package com.example.recyclerviewsample

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


data class Coffee(

		@field:SerializedName("coffeeName")
		val coffeeName: String? = null,

		@field:SerializedName("coffeePrice")
		val coffeePrice: String? = null,

		@field:SerializedName("image")
		val image: String? = null,
) : Parcelable{
	constructor(parcel: Parcel) : this(
			parcel.readString(),
			parcel.readString(),
			parcel.readString()) {
	}

	override fun writeToParcel(parcel: Parcel, flags: Int) {
		parcel.writeString(coffeeName)
		parcel.writeString(coffeePrice)
		parcel.writeString(image)
	}

	override fun describeContents(): Int {
		return 0
	}

	companion object CREATOR : Parcelable.Creator<Coffee> {
		override fun createFromParcel(parcel: Parcel): Coffee {
			return Coffee(parcel)
		}

		override fun newArray(size: Int): Array<Coffee?> {
			return arrayOfNulls(size)
		}
	}
}
