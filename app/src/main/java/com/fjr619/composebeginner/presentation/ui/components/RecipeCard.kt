package com.fjr619.composebeginner.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjr619.composebeginner.R
import com.fjr619.composebeginner.domain.model.Recipe
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(bottom = 6.dp, top = 6.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Column {
            recipe.featuredImage?.let { url ->
                GlideImage(
                    imageModel = url,
                    placeHolder = ImageBitmap.imageResource(R.drawable.empty_plate),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(225.dp),
                    contentScale = ContentScale.Crop
                )
            }

            recipe.title?.let { title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                ) {
                    Text(
                        text = title,
                        modifier = Modifier
                            .fillMaxWidth(0.85f) //fill sampe 85%
                            .wrapContentWidth(Alignment.Start),
                        style = MaterialTheme.typography.h5
                    )

                    Text(
                        text = recipe.rating.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically), //supaya ketengah
                        style = MaterialTheme.typography.h6
                    )
                }
            }
        }
    }
}