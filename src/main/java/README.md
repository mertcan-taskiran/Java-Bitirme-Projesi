# Java Bitirme Projesi

Case Detail

Bir fatura ödeme / sorgulama / ödeme iptali işlemlerinin olduğu proje yapacağız.

- Faturaları ilişkilendireceğimiz bir MemberAccount class, MemberAccountService gibi create/read/update/delete işlemleri yapan bir servis class,

- Fatura için amount, process_date, bill_type bilgileri tutulsun.

- Faturanın ödeme/sorgulama/ ödeme iptal metodlarının bulunması gereken servis class ı olacak.

- MemberAccount ın id+ismin ilk 2 harfinden oluşan bir memberCode bilgisi de olmalı ki faturayı bu koda göre sorgulayıp ödeme yapacak. MemberAccount ad, soyad, id, code, balance bilgileri içermeli.

- FaturaService class ını inherit edecek bir de Client class olsun. (inheritance anlatırken bir örnekleme yapmıştık).

- Service teki fatura metodlarını bu client üzerinden call edelim.

- Ek olarak client ta fatura tipine göre ödeme metodunu overload olacak şekilde 3 farklı impelementasyonunu gösterelim. (Fatura model class ta fatura tipi için bir attribute olmalı. Fatura tipleri ; 1- telefon / 2- internet 3 - su faturası. bu değerler int olarak alınsın)

- Client ta metodları çağırırken kullanıcıdan fatura tipini ve memberCode u alarak fatura işlem metodlarını çağıralım.

- Fatura tipi ve memberCode her fatura metodunda parametre olacak. Ödeme ve ödeme iptal de bunlara ek olarak amount ve fatura tarihini de parametreye ekleyelim.

- Ek olarak custom exception class oluşturalım. Ödeme ve ödeme iptal de girilen tutar ile müşteri hesabındaki tutar yeterli değilse exception mesajı oluştursun.