class PostBrief {
  late int id;
  late String nationalID;
  late String name;
  late DateTime? dateTime;
  late int count;
  late String bloodType;
  late double distance;
  late String hospitalName;
  late int state;
  PostBrief.fromJson(Map<String, dynamic> json, int state) {
    id = json['id'];
    nationalID = json['nationalID'];
    name = json['name'];
    dateTime = json['dateTime'] ?? DateTime.now();
    count = json['count'];
    bloodType = json['bloodType'];
    distance = json['distance'];
    hospitalName = json['hospitalName'];
    this.state = state;
  }
}
