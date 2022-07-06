# 대표적인 Mono 생성방법 2가지
- Mono.just() : just에 들어가는 내용은 값으로 인식한다.
- Mono.fromSupplier() : 실제 사용하는 시점(subscribe)에 내용을 가져온다.

# 대표적인 Flux 생성방법 2가지
- Flux.create() : create에 전달되는 내용이 값을 push 한다. - subscriber의 의사와 관계없이 push 한다.
- Flux.generate() : generate에 전달되는 내용이 pull 된다. subsctiber가 요청하는 만큼 pull 된다.