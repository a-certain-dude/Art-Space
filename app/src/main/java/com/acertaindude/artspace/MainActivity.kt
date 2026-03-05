package com.acertaindude.artspace


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acertaindude.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceAppLayout()
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ArtSpaceAppLayout() {
    var overAllCounter by remember { mutableIntStateOf(1) }

    val nextImage= when (overAllCounter) {
        1 -> R.drawable.allegory_of_love_1520
        2 -> R.drawable.concert_of_birds_1983_1660_1670
        3 -> R.drawable.free_images_national_gallery_of_art_3
        4 -> R.drawable.free_images_national_gallery_of_art_8
        5 -> R.drawable.harbor_at_sunset_late17century
        6 -> R.drawable.madonna_and_child_on_a_curved_throne_1260_1280
        7 -> R.drawable.old_woman_plucking_a_fowl_1650_1655
        8 -> R.drawable.pexels_jarosz_1727658
        9 -> R.drawable.portrait_of_a_donor_1470_1475
        10 -> R.drawable.portrait_of_a_woman_second_century
        11 -> R.drawable.portrait_of_a_young_lady_1500
        12 -> R.drawable.the_card_players_1550
        13 -> R.drawable.the_flight_into_egypt_150_1575
        14 -> R.drawable.the_herdsman_17or18cent
        else -> R.drawable.the_temptation_of_saint_anthony_1530
    }

    val nextText = when (overAllCounter) {
        1 -> R.string.allegory_of_love
        2 -> R.string.concert_of_birds_1983_1660_1670
        3 -> R.string.free_images_national_gallery_of_art_3
        4 -> R.string.free_images_national_gallery_of_art_8
        5 -> R.string.harbor_at_sunset_late17century
        6 -> R.string.madonna_and_child_on_a_curved_throne_1260_1280
        7 -> R.string.old_woman_plucking_a_fowl_1650_1655
        8 -> R.string.pexels_jarosz_1727658
        9 -> R.string.portrait_of_a_donor_1470_1475
        10 -> R.string.portrait_of_a_woman_second_century
        11 -> R.string.portrait_of_a_young_lady_1500
        12 -> R.string.the_card_players_1550
        13 -> R.string.the_flight_into_egypt_150_1575
        14 -> R.string.the_herdsman_17or18cent
        else -> R.string.the_temptation_of_saint_anthony_1530
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxHeight()
            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        CustomSurfaceWithImage(
            imageRes = nextImage,
            shadowElevation = 12.dp,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .padding(20.dp)
                .height(400.dp)
        )

        CustomDescriptionWithText(
            textRes = nextText,
            shadowElevation = 10.dp,
            shape = RoundedCornerShape(12.dp),
            color = Color.Cyan, modifier = Modifier.padding(16.dp)
        )


        CustomSurfaceWithTwoRowButton(
            buttonText1 = R.string.previous,
            buttonText2 = R.string.next,
            shadowElevation = 20.dp,
            shape = RoundedCornerShape(10.dp),
           // next = nextImage,
            onClickButton = { offset -> overAllCounter = (overAllCounter + offset).coerceIn(1..15) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

    }

}


@Composable
fun CustomSurfaceWithImage(
    /*@DrawableRes*/ imageRes: Int,
    shadowElevation: Dp,
    shape: RoundedCornerShape,
    modifier: Modifier = Modifier
) {

    Surface(shadowElevation = shadowElevation, shape = shape, modifier = modifier) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop, modifier = modifier
        )
    }

}

@Composable
fun CustomDescriptionWithText(
    /*@StringRes*/ textRes: Int,
    shadowElevation: Dp,
    shape: RoundedCornerShape,
    color: Color,
    modifier: Modifier = Modifier
) {
    Surface(shadowElevation = shadowElevation, shape = shape, color = color, modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = textRes),
                modifier = modifier,
                fontSize = 18.sp,
                color = Color.Black
            )
        }
    }
}


@Composable
fun CustomSurfaceWithTwoRowButton(
    /*@StringRes*/ buttonText1: Int,
    /*@StringRes*/ buttonText2: Int,
    shadowElevation: Dp,
    shape: RoundedCornerShape,
    //next: Int,
    onClickButton: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    Surface(shadowElevation = shadowElevation, shape = shape, modifier = modifier) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = modifier) {
            Button(onClick = { onClickButton(-1) }, shape = shape) {
                Text(text = stringResource(id = buttonText1))
            }

            Button(onClick = { onClickButton(1) }, shape = shape) {
                Text(text = stringResource(buttonText2))
            }
        }
    }


}