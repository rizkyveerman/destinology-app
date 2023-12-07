package com.ch2_ps397.destinology.ui.screen.camera

import androidx.camera.core.CameraSelector
import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavController
import com.ch2_ps397.destinology.R
import com.ch2_ps397.destinology.di.Injection
import com.ch2_ps397.destinology.ui.ViewModelFactory
import com.ch2_ps397.destinology.ui.components.camera.CameraPreview
import com.ch2_ps397.destinology.ui.components.sheets.PhotoBottomSheetContent
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinologyCameraScreen(
    navController: NavController,
    cameraXScreenViewModel: DestinologyCameraScreenViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    )
) {
    val context = LocalContext.current
    val scaffoldState = rememberBottomSheetScaffoldState()
    val controller = remember {
        LifecycleCameraController(context.applicationContext).apply {
            setEnabledUseCases(
                CameraController.IMAGE_CAPTURE
            )
        }
    }

    val scope = rememberCoroutineScope()
    val bitmaps by cameraXScreenViewModel.bitmaps.collectAsState()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 0.dp,
        sheetContent = {
            PhotoBottomSheetContent(
                bitmaps = bitmaps,
                modifier = Modifier.fillMaxWidth()
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            CameraPreview(
                controller = controller,
                modifier = Modifier
                    .fillMaxSize()
            )
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .padding(16.dp)
                        .background(
                            Color.White
                        )
                        .clickable {
                            scope.launch {
                                scaffoldState.bottomSheetState.expand()
                            }
                        },
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_image_24),
                        contentDescription = "open gallery"
                    )
                }

                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .padding(16.dp)
                        .background(
                            Color.White
                        )
                        .clickable {
                            takePhoto(
                                applicationContext = context.applicationContext,
                                controller = controller,
                                onPhotoTaken = cameraXScreenViewModel::onTakePhoto
                            )
                        },
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_photo_camera_24),
                        contentDescription = "open camera"
                    )
                }

                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .padding(16.dp)
                        .background(
                            Color.White
                        )
                        .clickable {
                            controller.cameraSelector =
                                if (controller.cameraSelector == CameraSelector.DEFAULT_BACK_CAMERA) {
                                    CameraSelector.DEFAULT_FRONT_CAMERA
                                } else CameraSelector.DEFAULT_BACK_CAMERA
                        },
                    contentAlignment = Alignment.Center,

                    ) {
                    Image(
                        painter = painterResource(
                            id = R.drawable.baseline_cameraswitch_24
                        ),
                        contentDescription = "Switch camera"
                    )
                }
            }
        }
    }
}