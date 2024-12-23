package com.jermorger.MutantsOfDiscord.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFood {
    /*
            MobEffects.MOVEMENT_SPEED	    Швидкість руху
            MobEffects.MOVEMENT_SLOWDOWN	Уповільнення руху
            MobEffects.DAMAGE_BOOST	        Збільшення сили атаки
            MobEffects.WEAKNESS	            Слабкість
            MobEffects.REGENERATION	        Регенірація здоров'я
            MobEffects.HEAL	                Миттєве зцілення
            MobEffects.HARM	                Миттєве нанесення шкоди
            MobEffects.JUMP	                Збільшення висоти стрибка
            MobEffects.POISON	            Отруєння
            MobEffects.WITHER	            Ефект визера
            MobEffects.NIGHT_VISION	        Нічне бачення
            MobEffects.INVISIBILITY	        Невидимість
            MobEffects.WATER_BREATHING	    Дихання під водою
            MobEffects.FIRE_RESISTANCE	    Стійкість до вогню
            MobEffects.HUNGER	            Збільшення голоду
            MobEffects.CONFUSION	        Дезорієнтація (ефект закрученості)
            MobEffects.BLINDNESS	        Сліпота
            MobEffects.ABSORPTION	        Поглинання (золоті серця)
            MobEffects.HEALTH_BOOST	        Збільшення максимального здоров'я
    */


    public static final FoodProperties COLAORIGINAL = new FoodProperties.Builder()
            .nutrition(5)
            .saturationMod(1.8f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 600, 0), 0.3f)
            .build();

    public static final FoodProperties COLA_999 = new FoodProperties.Builder()
            .nutrition(8)
            .saturationMod(2.0f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 900, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 900, 0), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 900, 3), 0.1f)
            .build();

    public static final FoodProperties PEPSI_ORIGINAL = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.GLOWING, 300, 0), 1.0f)
            .build();

    public static final FoodProperties OKROSHKA = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 600, 0), 0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600, 0), 1.0f)
            .build();


}
