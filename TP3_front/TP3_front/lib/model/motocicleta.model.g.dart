// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'motocicleta.model.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

Motocicleta _$MotocicletaFromJson(Map<String, dynamic> json) => Motocicleta(
      modelo: json['modelo'] as String,
      preco: (json['preco'] as num).toDouble(),
      id: json['id'] as String,
      marca: json['marca'] as String,
    );

Map<String, dynamic> _$MotocicletaToJson(Motocicleta instance) =>
    <String, dynamic>{
      'id': instance.id,
      'modelo': instance.modelo,
      'preco': instance.preco,
      'marca': instance.marca,
    };
