package cubex.mahesh.trainstatus_nov9am.beans

data class TrainStatusBean(
    var position:String,
    var train:Train,
    var route: MutableList<Route>
)