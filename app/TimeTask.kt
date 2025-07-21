class TimeTask {
    @Composable
    override fun TaskOptions () {

    }

    @Composable
    override fun TaskPage(modifier: Modifier) {
        Column (
            modifier = modifier
        ) {
            CircularProgressIndicator(
                progress = { getNowProgress() },
                modifier = modifier,
                trackColor = ProgressIndicatorDefaults.circularTrackColor,
            )
        }
    }

    private fun getNowProgress (): Float {
        return 1.0f/2.0f
    }
}
