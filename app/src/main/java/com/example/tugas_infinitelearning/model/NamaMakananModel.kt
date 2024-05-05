package com.example.tugas_infinitelearning.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.tugas_infinitelearning.R

data class NameFood(
    @StringRes val nama: Int,
    @StringRes val deskripsi: Int,
    @DrawableRes val image: Int,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(nama)
        dest.writeInt(deskripsi)
        dest.writeInt(image)
    }

    companion object CREATOR : Parcelable.Creator<NameFood> {
        override fun createFromParcel(parcel: Parcel): NameFood {
            return NameFood(parcel)
        }

        override fun newArray(size: Int): Array<NameFood?> {
            return arrayOfNulls(size)
        }
    }
}

fun loadFood(): List<NameFood> {
    return listOf(
        NameFood(R.string.name1, R.string.deskripsi1, R.drawable.nasi),
        NameFood(R.string.name2, R.string.deskripsi2, R.drawable.spageti),
        NameFood(R.string.name3, R.string.deskripsi3, R.drawable.roti),
        NameFood(R.string.name4, R.string.deskripsi4, R.drawable.kentang),
        NameFood(R.string.name5, R.string.deskripsi5, R.drawable.daging_sapi),
        NameFood(R.string.name6, R.string.deskripsi6, R.drawable.ayam),
        NameFood(R.string.name7, R.string.deskripsi7, R.drawable.ikan),
        NameFood(R.string.name8, R.string.deskripsi8, R.drawable.telur),
        NameFood(R.string.name9, R.string.deskripsi9, R.drawable.keju),
        NameFood(R.string.name10, R.string.deskripsi10, R.drawable.keripik),
    )
}