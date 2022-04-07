import 'package:json_annotation/json_annotation.dart';
part 'motocicleta.model.g.dart';

@JsonSerializable()
class Motocicleta {
  String modelo;
  double preco;
  String marca;
  String id;
  Motocicleta(
      {required this.modelo,
      required this.preco,
      required this.id,
      required this.marca});
  factory Motocicleta.fromJson(Map<String, dynamic> json) => _$MotocicletaFromJson(json);
  Map<String, dynamic> toJson() =>_$MotocicletaToJson(this);
}
